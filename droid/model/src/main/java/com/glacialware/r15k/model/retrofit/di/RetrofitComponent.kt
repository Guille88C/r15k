package com.glacialware.r15k.model.retrofit.di

import com.glacialware.r15k.model.retrofit.MissionController
import com.glacialware.r15k.model.retrofit.PlayerController
import dagger.Component
import javax.inject.Singleton

/**
* Created by Guille on 28/11/2017.
*/
@Singleton
@Component (
    modules = [(RetrofitModule::class)]
)
interface RetrofitComponent {
    fun inject(controller: MissionController)
    fun inject(controller: PlayerController)
}