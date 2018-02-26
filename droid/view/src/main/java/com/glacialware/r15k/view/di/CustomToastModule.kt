package com.glacialware.r15k.view.di

import android.content.Context
import com.glacialware.r15k.view.components.CustomToast
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
* Created by Guille on 16/11/2017.
*/
@Module
class CustomToastModule(private val context : Context) {
    @Provides
    @Singleton
    fun customToastInstance() : CustomToast = CustomToast(context)
}