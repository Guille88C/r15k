package com.glacialware.r15k.model.retrofit.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
* Created by Guille on 28/11/2017.
*/
@Module
class RetrofitModule {
    companion object {
        private const val BASE_URL = "http://192.168.1.35/r15k/"
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(provideGsonInstance()))
            .build()

    @Singleton
    @Provides
    fun provideGsonInstance(): Gson = GsonBuilder().setLenient().create()
}