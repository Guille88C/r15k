package com.glacialware.r15k.model.firebase.di

import com.google.firebase.firestore.FirebaseFirestore

object FirebaseDependency {
    fun provideFirebaseFirestore() = FirebaseFirestore.getInstance()
}