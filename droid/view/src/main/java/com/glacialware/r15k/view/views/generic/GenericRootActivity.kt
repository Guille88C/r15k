package com.glacialware.r15k.view.views.generic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.glacialware.r15k.view.RiskApplication
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.di.GenericActivityComponent
import com.glacialware.r15k.view.views.di.GenericActivityModule
import com.glacialware.r15k.view.wireframes.generic.GenericActivityWireframe
import com.glacialware.r15k.view.wireframes.navigateBackAnimated
import com.glacialware.r15k.viewmodel.views.generic.GenericViewModel

/**
* Created by Guille on 04/07/2017.
*/
abstract class GenericRootActivity constructor(private var anim: Boolean = false) : AppCompatActivity() {

    // ---- Attributes ----

    protected lateinit var mWireFrame: GenericActivityWireframe
    protected lateinit var mViewModel: GenericViewModel
    var mComponent: GenericActivityComponent? = null

    // ---- END Attributes ----

    // ---- Activity -----

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (anim) {
            this.overridePendingTransition(R.anim.slide_in_enter, R.anim.slide_out_enter)
        }

        // 0. Init dagger.
        // 1. View model.
        // 2. View.
        // 3. Presenter.
        // 4. Wireframe
        // 5. Fragment.
        initDI()
        initViewModel()
        initView()
        initPresenter()
        initWireframe()
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

    abstract fun initFragment()
    abstract fun initViewModel()
    abstract fun initView()
    abstract fun initPresenter()
    abstract fun initWireframe()

    // ---- END Abstract ----

    // ---- Protected ----

    protected fun isCreated() : Boolean = !isFinishing && !isDestroyed

    // ---- END Protected ----

    // ---- Private ----

    private fun initDI() {
        mComponent = (application as RiskApplication?)?.applicationComponent?.with(GenericActivityModule())
        mComponent?.inject(this)
    }

    // ---- END Private ----
}