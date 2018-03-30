package com.glacialware.r15k.view.views.generic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.glacialware.r15k.view.RiskApplication
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.di.ActivityComponent
import com.glacialware.r15k.view.views.di.ActivityModule
import com.glacialware.r15k.view.wireframes.generic.GenericActivityWireframe
import com.glacialware.r15k.view.wireframes.navigateBackAnimated
import com.glacialware.r15k.viewmodel.views.generic.GenericViewModel

/**
* Created by Guille on 04/07/2017.
*/
abstract class GenericRootActivity constructor(private var anim: Boolean = false) : AppCompatActivity() {

    // ---- Attributes ----

    protected lateinit var mViewModel: GenericViewModel

    var mComponent: ActivityComponent? = null
    private set

    protected lateinit var mActivityComponent: ActivityComponent

    // ---- END Attributes ----

    // ---- Activity -----

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (anim) {
            this.overridePendingTransition(R.anim.slide_in_enter, R.anim.slide_out_enter)
        }

        mActivityComponent = (application as RiskApplication).applicationComponent.with(ActivityModule(this))

        // - Init dagger.
        // - View model.
        // - View.
        // - Fragment.
        initDI()
        initViewModel()
        initView()
        initFragment()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (anim && this.supportFragmentManager.backStackEntryCount == 0) {
            navigateBackAnimated(this)
        }
    }

    // ---- END Activity ----

    // ---- Abstract ----

    abstract fun initDI()
    abstract fun initFragment()
    abstract fun initViewModel()
    abstract fun initView()

    // ---- END Abstract ----

    // ---- Protected ----

    protected fun isCreated() : Boolean = !isFinishing && !isDestroyed

    // ---- END Protected ----
}