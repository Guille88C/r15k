package com.glacialware.r15k.viewmodel.views.addPlayer

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

/**
 * Created by Guille on 15/11/2017.
 */
class AddPlayerViewModel : ViewModel(), LifecycleObserver {
    val namePlayer : ObservableField<String> = ObservableField("")

    fun addPlayer() {

    }
}