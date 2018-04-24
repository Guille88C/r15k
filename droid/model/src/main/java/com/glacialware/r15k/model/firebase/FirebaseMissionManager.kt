package com.glacialware.r15k.model.firebase

import android.arch.lifecycle.MutableLiveData
import com.glacialware.r15k.model.firebase.di.DaggerFirebaseComponent
import com.glacialware.r15k.model.firebase.di.FirebaseComponent
import com.glacialware.r15k.model.firebase.di.FirebaseModule
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class FirebaseMissionManager {

    // ---- Attributes ----
    val ldListMissions = MutableLiveData<MutableList<FirebaseMission>>()

//    val oListMissions = PublishSubject.fromArray(lMissions).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
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

    // ---- Public ----
    fun getMissions() {
        mFirestore.collection("missions").get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val lMissions = ArrayList<FirebaseMission>()
                val lDocuments = task.result.documents
                lDocuments.forEach { document ->
                    val title = document.data?.get("title") as String? ?: ""
                    val desc = document.data?.get("description") as String? ?: ""
                    val completed = document.data?.get("completed") as Boolean? ?: false
                    lMissions.add(FirebaseMission(title = title, description = desc, completed = completed))
                }

                if (ldListMissions.value == null) {
                    ldListMissions.value = lMissions
                }
                else {
                    ldListMissions.value?.clear()
                    ldListMissions.postValue(lMissions)
                }
            }
        }
    }
    // ---- END Public ----
}