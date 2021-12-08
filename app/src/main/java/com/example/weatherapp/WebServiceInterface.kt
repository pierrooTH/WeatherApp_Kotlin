package com.example.weatherapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebServiceInterface {

    @GET("current.json")
    fun getJson(@Query("key") key : String, @Query("q") q : String, @Query("lang") lang : String): Call<Weather>


    @GET("forecast.json")
    fun getForeCastJson(@Query("key") key : String, @Query("q") q : String, @Query("days") days : String, @Query("lang") lang : String): Call<Weather>
}