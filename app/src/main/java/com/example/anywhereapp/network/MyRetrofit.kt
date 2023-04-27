package com.example.anywhereapp.network

import com.example.myanywhereapplication.simpsons.model.Simpsons
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MyRetrofit {
    companion object{
        fun MakeRetrofit() : Retrofit = Retrofit.Builder()
            .baseUrl("http://api.duckduckgo.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        fun getService() : RetrofitService = MakeRetrofit()
            .create(RetrofitService::class.java)
    }
}

interface RetrofitService {
    @GET("?q=simpsons+characters&format=json")
    suspend fun getSimpsons() : Response<Simpsons>
}