package com.jocker.jlife.ui.top250

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.jocker.jlife.beans.Subjects
import com.jocker.jlife.db.JLifeDatabase
import com.jocker.jlife.db.SubjectBean
import com.jocker.jlife.db.SubjectsDao

class Top250ViewModel(
        application: Application,
        private val top250Repository: Top250Repository) : AndroidViewModel(application) {

    private val subjectsDao: SubjectsDao = JLifeDatabase.getInstance(application).getSubjectsDao()
    val top250Movies: LiveData<PagedList<Subjects>> = LivePagedListBuilder(
            subjectsDao.querySubjects(), PagedList.Config.Builder()
            .setPageSize(20)
            .setEnablePlaceholders(true)
            .build()).build()

    init {
        top250Repository.getTop250FromServer(subjectsDao)
    }


}