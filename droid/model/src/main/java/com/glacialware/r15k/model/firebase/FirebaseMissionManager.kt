package com.glacialware.r15k.model.firebase

import com.glacialware.r15k.model.firebase.di.FirebaseDependency
import com.google.firebase.firestore.FirebaseFirestore
import io.reactivex.Observable
import io.reactivex.ObservableEmitter

class FirebaseMissionManager {
    // ---- Companion ----
    companion object {
        const val FIRESTORE_COLLECTION = "missions"
        const val FIRESTORE_FIELD_TITLE = "title"
        const val FIRESTORE_FIELD_DESCRIPTION = "description"
        const val FIRESTORE_FIELD_COMPLETED = "completed"
    }
    // ---- END Companion ----

    // ---- Attributes ----
    val oMissions: Observable<FirebaseMission> = Observable.create<FirebaseMission> { emitter ->
        getMissions(emitter)
    }

    private val mFirestore: FirebaseFirestore = FirebaseDependency.provideFirebaseFirestore()
    // ---- END Attributes ----

    // ---- Private ----
    private fun getMissions(emitter: ObservableEmitter<FirebaseMission>) {
        mFirestore.collection(FIRESTORE_COLLECTION).get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val lDocuments = task.result.documents
                lDocuments.forEach { document ->
                    val title = document.data?.get(FIRESTORE_FIELD_TITLE) as String? ?: ""
                    val desc = document.data?.get(FIRESTORE_FIELD_DESCRIPTION) as String? ?: ""
                    val completed = document.data?.get(FIRESTORE_FIELD_COMPLETED) as Boolean? ?: false
                    emitter.onNext(FirebaseMission(title = title, description = desc, completed = completed))
                }
            }
            emitter.onComplete()
        }
    }
    // ---- END Private ----
}