package com.jocker.jlife.beans



data class MoviesBean constructor(
        val title: String,
        val count: Int,
        val start: Int,
        val total: Int,
        var subjects: List<Subjects>
)