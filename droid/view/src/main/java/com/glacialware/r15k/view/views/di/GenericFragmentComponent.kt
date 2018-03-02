package com.glacialware.r15k.view.views.di

import com.glacialware.r15k.scopes.PerFragment
import com.glacialware.r15k.view.presenters.di.GenericFragmentPresenterComponent
import com.glacialware.r15k.view.presenters.di.GenericFragmentPresenterModule
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import dagger.Subcomponent

/**
 * Created by gcuestab on 28/2/18.
 */
@PerFragment
@Subcomponent(modules = [(GenericFragmentModule::class)])
interface GenericFragmentComponent {
    fun inject(fragment: GenericRootFragment)

    fun with(module: GenericFragmentPresenterModule): GenericFragmentPresenterComponent
}