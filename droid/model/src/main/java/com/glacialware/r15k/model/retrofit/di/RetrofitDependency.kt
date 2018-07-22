package com.glacialware.r15k.model.retrofit.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitDependency {
    private const val BASE_URL = "http://192.168.1.35/r15k/"

    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(provideGsonInstance()))
            .build()

    fun provideGsonInstance(): Gson = GsonBuilder().setLenient().create()
}