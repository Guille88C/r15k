package com.glacialware.r15k.view.views.di

import android.databinding.ViewDataBinding
import com.glacialware.r15k.view.scopes.PerActivity
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import com.glacialware.r15k.view.wireframes.generic.GenericFragmentWireframe
import com.glacialware.r15k.viewmodel.views.generic.GenericViewModel
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