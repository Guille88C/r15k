package com.glacialware.r15k.view.views.di

import com.glacialware.r15k.view.scopes.PerActivity
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import dagger.Subcomponent

/**
 * Created by gcuestab on 28/2/18.
 */
@PerActivity
@Subcomponent(modules = ([ActivityModule::class]))
interface ActivityComponent {
    fun inject(activity: GenericRootActivity)

    fun with(module: FragmentModule): FragmentComponent
}