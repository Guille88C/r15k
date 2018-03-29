package com.glacialware.r15k.view.views.di

import android.databinding.ViewDataBinding
import com.glacialware.r15k.view.scopes.PerFragment
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import com.glacialware.r15k.view.wireframes.generic.GenericFragmentWireframe
import com.glacialware.r15k.viewmodel.views.generic.GenericViewModel
import dagger.Subcomponent

/**
 * Created by gcuestab on 28/2/18.
 */
@PerFragment
@Subcomponent(modules = [(GenericFragmentModule::class)])
interface GenericFragmentComponent {
    fun inject(fragment: GenericRootFragment<GenericFragmentWireframe, GenericViewModel, ViewDataBinding>)
}