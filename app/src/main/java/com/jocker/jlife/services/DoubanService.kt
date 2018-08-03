package com.jocker.jlife.services

import com.jocker.jlife.beans.MoviesBean
import com.jocker.jlife.beans.MovieDetailBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface DoubanService {
//    最近热映
    @GET("/v2/movie/in_theaters")
    fun getInTheaterMovies(): Observable<MoviesBean>
//   详情
    @GET("/v2/movie/subject/{id}")
    fun getInThreaterMovieDetail(@Path("id") id:Int):Observable<MovieDetailBean>

//    top 250
    @GET("/v2/movie/top250")
    fun getTop250():Observable<MoviesBean>
}