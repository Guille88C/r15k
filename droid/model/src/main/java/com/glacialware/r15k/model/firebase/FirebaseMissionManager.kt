package com.glacialware.r15k.model.firebase

import com.glacialware.r15k.model.firebase.di.DaggerFirebaseComponent
import com.glacialware.r15k.model.firebase.di.FirebaseComponent
import com.glacialware.r15k.model.firebase.di.FirebaseModule
import com.google.firebase.firestore.FirebaseFirestore
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import javax.inject.Inject

class FirebaseMissionManager {

    // ---- Attributes ----
    val oMissions: Observable<FirebaseMission> = Observable.create<FirebaseMission> { emitter ->
        getMissions(emitter)
    }
    // ---- END Attributes ----

    // ---- Dagger attributes ----
    private val mComponent: FirebaseComponent by lazy {
        DaggerFirebaseComponent.builder()
                .firebaseModule(FirebaseModule())
                .build()
    }

    @Inject
    lateinit var mFirestore: FirebaseFirestore
    // ---- END Dagger attributes ----

    // ---- Builder ----
    init {
        mComponent.inject(this)
    }
    // ---- END Builder ----

    // ---- Private ----
    private fun getMissions(emitter: ObservableEmitter<FirebaseMission>) {
        mFirestore.collection("missions").get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
//                val lMissions = ArrayList<FirebaseMission>()
                val lDocuments = task.result.documents
                lDocuments.forEach { document ->
                    val title = document.data?.get("title") as String? ?: ""
                    val desc = document.data?.get("description") as String? ?: ""
                    val completed = document.data?.get("completed") as Boolean? ?: false
                    emitter.onNext(FirebaseMission(title = title, description = desc, completed = completed))
                }
            }
            emitter.onComplete()
        }
    }
    // ---- END Private ----
}