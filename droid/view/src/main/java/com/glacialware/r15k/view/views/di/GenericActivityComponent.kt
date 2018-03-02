package com.glacialware.r15k.view.views.di

import com.glacialware.r15k.scopes.PerActivity
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import dagger.Subcomponent

/**
 * Created by gcuestab on 28/2/18.
 */
@PerActivity
@Subcomponent(modules = ([GenericActivityModule::class]))
interface GenericActivityComponent {
    fun inject(activity: GenericRootActivity)

    fun with(module: GenericFragmentModule): GenericFragmentComponent
}