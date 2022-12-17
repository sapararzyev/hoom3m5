package com.example.hoom3m5

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    private fun getClient():OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(provisdeInterceptor())
            .build()
    }
    private fun provisdeInterceptor():HttpLoggingInterceptor{
        val loger=HttpLoggingInterceptor()
        loger.level = HttpLoggingInterceptor.Level.BODY
        return loger
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pixabay.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(getClient())
        .build()

    fun getApi() = retrofit.create(PixApi::class.java)

}