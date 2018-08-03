package com.jocker.jlife.net

import androidx.databinding.ObservableField
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.jocker.jlife.MyObserver
import com.jocker.jlife.beans.MoviesBean
import com.jocker.jlife.beans.MovieDetailBean
import com.jocker.jlife.beans.Subjects
import com.jocker.jlife.db.SubjectsDao
import com.jocker.jlife.services.DoubanService
import com.jocker.jlife.utilties.DOUBAN_BASE
import com.jocker.jlife.utilties.LogUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetManager private constructor() {
    private var mRetrofit: Retrofit
    private var mOkHttpClient: OkHttpClient


    companion object {
        private var instance: NetManager? = null
        fun getInstance() = instance ?: synchronized(this) {
            instance ?: NetManager().also {
                instance = it
            }
        }
    }

    init {
        val okHttpBuilder = OkHttpClient.Builder()
        mOkHttpClient = okHttpBuilder.connectTimeout(8, TimeUnit.SECONDS).readTimeout(8, TimeUnit.SECONDS).build()
        val builder = Retrofit.Builder()
        builder.addConverterFactory(GsonConverterFactory.create())
        builder.baseUrl(DOUBAN_BASE)
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        mRetrofit = builder.client(mOkHttpClient).build()
    }

    fun setNewBaseUrl(baseUrl: String) {
        mRetrofit = mRetrofit.newBuilder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).client(mOkHttpClient).build()
    }

    fun getTop250(subjectsDao: SubjectsDao) {
        mRetrofit.create(DoubanService::class.java).getTop250()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(object : MyObserver<MoviesBean>() {
                    override fun onNext(t: MoviesBean) {
//                        需要在子线程中进行数据库的写入
                        subjectsDao.insertSubject(t.subjects)
//                        mb.insertTop250Subjects(t.su bjects)
                    }

                    override fun onError(e: Throwable) {
                    }
                })

    }

    //获取最近电影
    fun getMovieInTheater(subjectsBean: MediatorLiveData<MutableList<Subjects>>,
                          mutableList: MutableLiveData<MutableList<Subjects>>) {
        val create = mRetrofit.create(DoubanService::class.java)
        create.getInTheaterMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : MyObserver<MoviesBean>() {
                    override fun onNext(t: MoviesBean) {
                        mutableList.value!!.addAll(t.subjects)
                        subjectsBean.addSource(mutableList, subjectsBean::setValue)
                    }

                    override fun onError(e: Throwable) {
                        subjectsBean.value?.clear()
                    }
                })

    }

    fun getMovieDetail(id: Int, movieDetailLiveData: ObservableField<MovieDetailBean>) {
        val create = mRetrofit.create(DoubanService::class.java)
        create.getInThreaterMovieDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : MyObserver<MovieDetailBean>() {
                    override fun onNext(t: MovieDetailBean) {
                        movieDetailLiveData.set(t)
                    }

                    override fun onError(e: Throwable) {
                        LogUtil.logW("获取电影详情错误：", e.toString())
                    }

                })
    }


}