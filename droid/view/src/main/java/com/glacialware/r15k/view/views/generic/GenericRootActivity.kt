package com.glacialware.r15k.view.views.generic

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.wireframes.Wireframe
import com.glacialware.r15k.viewmodel.views.generic.GenericViewModel
import kotlinx.android.synthetic.main.activity_main.*

/**
* Created by Guille on 04/07/2017.
*/
abstract class GenericRootActivity<T: GenericViewModel> (private var anim: Boolean = false) : AppCompatActivity() {

    // ---- Attributes ----

    protected lateinit var mViewModel: T

    // ---- END Attributes ----

    // ---- Activity -----

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (anim) {
            this.overridePendingTransition(R.anim.slide_in_enter, R.anim.slide_out_enter)
        }

        // - Init dagger.
        // - View model.
        // - View.
        // - Toolbar.
        // - Fragment.
        initDI()
        initViewModel()
        initView()
        initToolbar()
        initFragment()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (anim && this.supportFragmentManager.backStackEntryCount == 0) {
            Wireframe.navigateBackAnimated(this)
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

    // ---- Private ----

    private fun initToolbar() {
        if (myToolbar != null)
            this.setSupportActionBar(myToolbar as Toolbar)

        if (this.supportActionBar != null) {
            (this.supportActionBar as ActionBar).setDisplayHomeAsUpEnabled(true)
            (this.supportActionBar as ActionBar).setHomeButtonEnabled(true)
        }
    }

    // ---- END Private ----
}