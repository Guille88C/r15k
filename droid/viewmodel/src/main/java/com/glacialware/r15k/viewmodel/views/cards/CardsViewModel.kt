package com.glacialware.r15k.viewmodel.views.cards

import android.app.Application
import android.arch.lifecycle.*
import com.glacialware.r15k.viewmodel.model.Mission
import com.glacialware.r15k.viewmodel.views.generic.GenericDatabaseViewModel
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy

/**
 * Created by gcuestab on 2/4/18.
 */
class CardsViewModel(app: Application): GenericDatabaseViewModel(app) {
    // ---- Attributes ----
    private val mListMission = ArrayList<Mission>()
    private var mObserverDisposable: Disposable? = null
    // ---- END Attributes ----

    // ---- Properties ----
    val ldMissions: MutableLiveData<MutableList<Mission>> = MutableLiveData()
    // ---- END Properties

    // ---- Builder ----
    init {
        mObserverDisposable = mFirebaseMissionManager.oMissions.subscribeBy (
                onNext = {
                    item ->
                    val mission = Mission()
                    mission.fromFirebase(item)
                    mListMission.add(mission)
                },
                onComplete = {
                    if (ldMissions.value == null) {
                        ldMissions.value = mListMission
                    }
                    else {
                        ldMissions.value?.clear()
                        ldMissions.postValue(mListMission)
                    }
                }
        )
    }
    // ---- END Builder ----

    // ---- Public  ----
    fun clear() {
        mObserverDisposable?.dispose()
    }
    // ---- END Public ----

    // ---- Events ----
    fun onMissionClick(mission: Mission) {

    }
    // ---- END Events ----
}