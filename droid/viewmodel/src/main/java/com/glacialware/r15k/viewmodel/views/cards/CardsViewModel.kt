package com.glacialware.r15k.viewmodel.views.cards

import android.app.Application
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.glacialware.r15k.model.firebase.FirebaseMission
import com.glacialware.r15k.viewmodel.model.Mission
import com.glacialware.r15k.viewmodel.views.generic.GenericDatabaseViewModel

/**
 * Created by gcuestab on 2/4/18.
 */
class CardsViewModel(app: Application): GenericDatabaseViewModel(app) {
    // ---- Observer ----
    private val mObserver = Observer<MutableList<FirebaseMission>> {
        list ->
        val listMissions = ArrayList<Mission>()
        list?.forEach { item ->
            val mission = Mission()
            mission.fromFirebase(item)
            listMissions.add(mission)
        }
        if (ldMissions.value == null) {
            ldMissions.value = listMissions
        } else {
            ldMissions.value?.clear()
            ldMissions.postValue(listMissions)
        }
    }
    // ---- END Observer ----

    // ---- Properties ----
    var ldMissions: MutableLiveData<MutableList<Mission>> = MutableLiveData()

    var lifecycleVM: LifecycleOwner? = null
    set(value) {
        if (value != null && !mFirebaseMissionManager.ldListMissions.hasObservers()) {
            mFirebaseMissionManager.ldListMissions.observe(value, mObserver)
            mFirebaseMissionManager.getMissions()
        }
        field = value
    }
    // ---- END Properties
}