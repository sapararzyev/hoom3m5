package com.example.hoom3m5

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixApi {

    @GET("api/")
    fun getimeg(
        @Query("key") Key: String = "32118220-ac624a5de30f0a59f181d77fc",
        @Query("q") q : String,
        @Query("page")page : Int = 1,
        @Query("per_page") per_page: Int = 20
    ):Call<PixModel>

}