package com.glacialware.r15k.viewmodel.di

import com.glacialware.r15k.viewmodel.views.GenericDatabaseViewModel
import dagger.Component
import javax.inject.Singleton

/**
* Created by Guille on 28/11/2017.
*/
@Singleton
@Component (
    modules = [(AppDatabaseModule::class)]
)
interface AppDatabaseComponent {
    fun inject(databaseVM: GenericDatabaseViewModel)
}