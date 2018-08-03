package com.jocker.jlife.utilties

import android.app.Application
import android.content.Context
import com.jocker.jlife.ui.main.MainRepository
import com.jocker.jlife.ui.detail.DetailProviderFactory
import com.jocker.jlife.ui.detail.DetailRepository
import com.jocker.jlife.ui.main.MainFragmentProviderFactory
import com.jocker.jlife.ui.top250.Top250ProviderFactory
import com.jocker.jlife.ui.top250.Top250Repository

object InjectUtil {
    fun getMainFragmentProviderFactory(): MainFragmentProviderFactory {
        val mainRepository = MainRepository.get()
        return MainFragmentProviderFactory(mainRepository)
    }

    fun getDetailFragmentProviderFactory(mId: Int): DetailProviderFactory {
        return DetailProviderFactory(mId, DetailRepository.getInstance())
    }

    fun getTop250FragmentProviderFactory(application: Application, context: Context): Top250ProviderFactory {
        val top250Repository = Top250Repository.getInstance(context)
        return Top250ProviderFactory(application, top250Repository)
    }

}