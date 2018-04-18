package com.glacialware.r15k.viewmodel.views.cards

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.glacialware.r15k.viewmodel.model.Mission
import com.glacialware.r15k.viewmodel.views.generic.GenericViewModel
import com.google.firebase.firestore.FirebaseFirestore

/**
 * Created by gcuestab on 2/4/18.
 */
class CardsViewModel(app: Application): GenericViewModel(app) {
    // ---- Properties ----
    var lMissions: MutableLiveData<MutableList<Mission>> = MutableLiveData()
    // ---- END Properties

    // ---- Attributes ----
    private val mFirebaseStore = FirebaseFirestore.getInstance()
    // ---- END Attributes ----

    // ---- Builder ----
    init {
        this.mFirebaseStore.collection("missions").get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val tempListMissions = ArrayList<Mission>()
                val lDocuments = task.result.documents
                lMissions.value?.clear()
                lDocuments.forEach { document ->
                    val title = document.data?.get("title") as String? ?: ""
                    val desc = document.data?.get("description") as String? ?: ""
                    val completed = document.data?.get("completed") as Boolean? ?: false
                    tempListMissions.add(Mission(title = title, description = desc, completed = completed))
                }

                if (lMissions.value == null) {
                    lMissions.value = tempListMissions
                }
                else {
                    lMissions.postValue(tempListMissions)
                }
            }
        }
    }
    // ---- END Builder ----


}