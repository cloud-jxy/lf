package com.jocker.jlife.db

import android.content.Context
import androidx.room.Room
import androidx.test.InstrumentationRegistry
import org.junit.Test

class JLifeDatabaseTest {

    @Test
    fun getMovieBeanDao() {
        val context: Context = InstrumentationRegistry.getTargetContext()
        val inMemoryDatabaseBuilder = Room.inMemoryDatabaseBuilder(context, JLifeDatabase::class.java)
        val build = inMemoryDatabaseBuilder.build()

    }
}