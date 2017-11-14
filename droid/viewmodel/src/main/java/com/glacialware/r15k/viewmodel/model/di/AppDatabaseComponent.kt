package com.glacialware.r15k.viewmodel.model.di

import com.glacialware.r15k.viewmodel.views.main.PlayersViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Guille on 14/11/2017.
 */
@Singleton
@Component(
        modules = arrayOf(AppDatabaseModule::class)
)
interface AppDatabaseComponent {
    fun inject(playersVM: PlayersViewModel)
}