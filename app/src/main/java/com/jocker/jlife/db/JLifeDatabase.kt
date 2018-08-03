package com.jocker.jlife.db

import android.content.Context
import androidx.room.*
import com.jocker.jlife.utilties.DbTypeConverter

@Database(entities = [
    SubjectBean::class,
    CastBean::class,
    DirectorBean::class], version = 2, exportSchema = false)
@TypeConverters(DbTypeConverter::class)
abstract class JLifeDatabase : RoomDatabase() {

    abstract fun getSubjectsDao(): SubjectsDao

    companion object {
        @Volatile
        private var jLifeDatabase: JLifeDatabase? = null

        fun getInstance(context: Context): JLifeDatabase = jLifeDatabase ?: synchronized(this) {
            jLifeDatabase ?: buildRoomDataBase(context).also {
                jLifeDatabase = it
            }
        }

        private fun buildRoomDataBase(context: Context): JLifeDatabase {
            return Room.databaseBuilder(context, JLifeDatabase::class.java, DB_NAME).build()
        }
    }

}