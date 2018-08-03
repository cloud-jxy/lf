package com.jocker.jlife.ui.top250

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class Top250ProviderFactory constructor(private val application: Application, private val top250Repository: Top250Repository)
    : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return Top250ViewModel(application, top250Repository) as T
    }
}