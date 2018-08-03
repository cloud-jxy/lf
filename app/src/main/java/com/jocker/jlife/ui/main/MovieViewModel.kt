package com.jocker.jlife.ui.main

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jocker.jlife.beans.Subjects


class MovieViewModel (mainRepository: MainRepository) : ViewModel() {
    val subjectsBean: MediatorLiveData<MutableList<Subjects>> = MediatorLiveData()

    init {
        val mutableList = MutableLiveData<MutableList<Subjects>>()
        mutableList.value = mutableListOf()
        mainRepository.getInTheaterMovies(subjectsBean, mutableList)
//        subjectsBean.addSource(mutableList,subjectsBean::setValue)
    }

    fun getInTheaterMovies() {
//        mainRepository.getInTheaterMovies(subjectsBean, mutableList)
    }

}
