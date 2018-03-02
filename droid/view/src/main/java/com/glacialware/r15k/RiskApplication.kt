package com.glacialware.r15k

import android.app.Application
import com.glacialware.r15k.di.ApplicationComponent
import com.glacialware.r15k.di.DaggerApplicationComponent

/**
 * Created by gcuestab on 28/2/18.
 */
class RiskApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()
        applicationComponent.inject(this)
    }
}