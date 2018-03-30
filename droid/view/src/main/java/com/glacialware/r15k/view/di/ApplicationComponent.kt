package com.glacialware.r15k.view.di

import com.glacialware.r15k.view.RiskApplication
import com.glacialware.r15k.view.views.di.ActivityComponent
import com.glacialware.r15k.view.views.di.ActivityModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by gcuestab on 28/2/18.
 */

@Singleton
@Component (modules = [(ApplicationModule::class)])
interface ApplicationComponent {
    fun inject(app: RiskApplication)

    fun with(module: ActivityModule): ActivityComponent
}