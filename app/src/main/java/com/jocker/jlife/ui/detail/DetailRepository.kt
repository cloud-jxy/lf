package com.jocker.jlife.ui.detail

import androidx.databinding.ObservableField
import com.jocker.jlife.beans.MovieDetailBean
import com.jocker.jlife.net.NetManager

class DetailRepository {
    fun getMovieDetail(id: Int, movieDetailLiveData: ObservableField<MovieDetailBean>) {
        NetManager.getInstance().getMovieDetail(id,movieDetailLiveData)
    }

    object Inner {
        val instance: DetailRepository = DetailRepository()
    }

    companion object {
        fun getInstance() = Inner.instance
    }


}