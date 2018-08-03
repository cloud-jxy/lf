package com.jocker.jlife.ui.top250

import android.content.Context
import com.jocker.jlife.db.JLifeDatabase
import com.jocker.jlife.db.SubjectsDao
import com.jocker.jlife.net.NetManager

class Top250Repository {
    companion object {
        private var top250Repository: Top250Repository? = null

        fun getInstance(context: Context): Top250Repository = top250Repository
                ?: synchronized(this) {
                    top250Repository ?: Top250Repository().also {
                        top250Repository = it
                    }
                }

    }



    fun getTop250FromServer(subjectsDao: SubjectsDao) {
        NetManager.getInstance().getTop250(subjectsDao)
    }


}