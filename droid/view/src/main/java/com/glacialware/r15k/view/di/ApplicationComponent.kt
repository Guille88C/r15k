package com.glacialware.r15k.view.di

import android.databinding.ViewDataBinding
import com.glacialware.r15k.view.RiskApplication
import com.glacialware.r15k.view.views.di.GenericActivityComponent
import com.glacialware.r15k.view.views.di.GenericActivityModule
import com.glacialware.r15k.view.wireframes.generic.GenericFragmentWireframe
import com.glacialware.r15k.viewmodel.views.generic.GenericViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by gcuestab on 28/2/18.
 */

@Singleton
@Component (modules = [(ApplicationModule::class)])
interface ApplicationComponent {
    fun inject(app: RiskApplication)

    fun with(module: GenericActivityModule): GenericActivityComponent
}