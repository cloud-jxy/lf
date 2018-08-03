package com.jocker.jlife.utilties

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DbTypeConverter {

    @TypeConverter
    fun convertStringListToString(list: List<String>): String
            = Gson().toJson(list)

    @TypeConverter
    fun convertStringToStringList(string: String): List<String>
            = Gson().fromJson<List<String>>(string, object : TypeToken<List<String>>() {}.type)
}