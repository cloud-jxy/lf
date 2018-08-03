package com.jocker.jlife.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.test.InstrumentationRegistry
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jocker.jlife.beans.MoviesBean
import org.junit.Before
import org.junit.Test

class SubjectDaoTest {
    private lateinit var database: JLifeDatabase
    private val list:MutableList<SubjectBean> = mutableListOf()
    @Before
    fun getDb() {
        val context: Context = InstrumentationRegistry.getTargetContext()
        database = Room.inMemoryDatabaseBuilder(context, JLifeDatabase::class.java).build()

    }

    @Test
    fun insertTest() {

    }
}