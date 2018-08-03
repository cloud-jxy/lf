package com.jocker.jlife.utilties

import org.junit.Before
import org.junit.Test

class DbTypeConverterTest {

    @Before
    fun setUp() {

    }

    @Test
    fun convertStringListToString() {
        val add = listOf<String>("犯罪","剧情")
        val converStringToStringList = DbTypeConverter().convertStringListToString(add)
        System.out.print(converStringToStringList)
    }

    @Test
    fun converStringToStringList() {
        val string = "[犯罪,剧情]"
        val converStringToStringList = DbTypeConverter().convertStringToStringList(string)
        for (s in converStringToStringList) {
            System.out.println(s)
        }
    }
}