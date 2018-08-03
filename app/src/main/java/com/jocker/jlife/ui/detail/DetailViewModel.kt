package com.jocker.jlife.ui.detail

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jocker.jlife.beans.MovieDetailBean

class DetailViewModel constructor(id:Int, detailRepository: DetailRepository) : ViewModel() {
    var movieDetailLiveData: ObservableField<MovieDetailBean> = ObservableField()
    init {
        detailRepository.getMovieDetail(id,movieDetailLiveData)
    }




}