package com.glacialware.r15k.viewmodel.views.di

import com.glacialware.r15k.viewmodel.scopes.PerViewModel
import com.glacialware.r15k.viewmodel.views.generic.GenericDatabaseViewModel
import dagger.Component

/**
* Created by Guille on 28/11/2017.
*/
@PerViewModel
@Component (
    modules = [(GenericDatabaseViewModelModule::class)]
)
interface GenericDatabaseViewModelComponent {
    fun inject(databaseVM: GenericDatabaseViewModel)
}