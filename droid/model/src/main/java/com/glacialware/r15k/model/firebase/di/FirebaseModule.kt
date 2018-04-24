package com.glacialware.r15k.model.firebase.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FirebaseModule {
    @Singleton
    @Provides
    fun provideFirestore() = FirebaseFirestore.getInstance()
}