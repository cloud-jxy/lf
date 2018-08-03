package com.jocker.jlife.beans

data class MovieDetailBean constructor(
        val rating: Rating,
        val reviews_count: Int,
        val wish_count: Int,
        val year: Int,
        val images: Avaters,
        val id: Int,
        val title: String,
        val original_title: String,
        val summary: String) {
}