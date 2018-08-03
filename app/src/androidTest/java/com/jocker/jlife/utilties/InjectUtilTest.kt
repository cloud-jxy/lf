package com.jocker.jlife.utilties

import android.content.Context
import androidx.room.Room
import androidx.test.InstrumentationRegistry
import com.jocker.jlife.db.JLifeDatabase
import com.jocker.jlife.net.NetManager
import org.junit.Test

import org.junit.Before

class InjectUtilTest {
    private lateinit var jLifeDatabase: JLifeDatabase

    @Before
    fun createDb() {
        val context: Context = InstrumentationRegistry.getTargetContext()
        jLifeDatabase = Room.inMemoryDatabaseBuilder(context, JLifeDatabase::class.java).build()
    }
//
//    @After
//    fun closeDb(){
//        jLifeDatabase.close()
//    }



    @Test
    fun getTop250FragmentProviderFactory() {
        val instance = NetManager.getInstance()
//        instance.getTop250(movieBeanDao)
    }
}