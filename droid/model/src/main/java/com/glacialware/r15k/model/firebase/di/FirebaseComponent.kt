package com.glacialware.r15k.model.firebase.di

import com.glacialware.r15k.model.firebase.FirebaseMissionManager
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [FirebaseModule::class])
interface FirebaseComponent {
    fun inject(manager: FirebaseMissionManager)
}
