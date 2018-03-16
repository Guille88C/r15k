package com.glacialware.r15k.viewmodel.views.generic

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LifecycleObserver

/**
 * Created by gcuestab on 5/3/18.
 */
abstract class GenericViewModel(app: Application): AndroidViewModel(app), LifecycleObserver