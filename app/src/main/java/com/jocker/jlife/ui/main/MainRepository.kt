package com.jocker.jlife.ui.main

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.jocker.jlife.beans.Subjects
import com.jocker.jlife.net.NetManager


class MainRepository {

    private object Inner{
     val instance = MainRepository()
    }

    companion object {
        fun get(): MainRepository {
            return Inner.instance
        }
    }

    fun getInTheaterMovies(subjectsBean: MediatorLiveData<MutableList<Subjects>>
                           , mutableList: MutableLiveData<MutableList<Subjects>>) {
        NetManager.getInstance().getMovieInTheater(subjectsBean,mutableList)
    }
}