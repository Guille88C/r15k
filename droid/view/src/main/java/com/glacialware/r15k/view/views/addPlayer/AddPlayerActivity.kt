package com.glacialware.r15k.view.views.addPlayer

import android.arch.lifecycle.ViewModelProviders
import android.view.MenuItem
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.di.ActivityDependency
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import com.glacialware.r15k.viewmodel.views.addPlayer.AddPlayerViewModel

/**
* Created by Guille on 09/07/2017.
*/
class AddPlayerActivity : GenericRootActivity<AddPlayerViewModel>(true) {

    // ---- Attributes ----
    private val mWireFrame = ActivityDependency.provideAddPlayerWireframe(this)
    // ---- END Attributes ----

    // ---- GenericRootActivity ----

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                android.R.id.home -> this.onBackPressed()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun initDI() {
    }

    override fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(AddPlayerViewModel::class.java)
    }

    override fun initView() {
        this.setContentView(R.layout.activity_generic_toolbar)
    }

    override fun initFragment() {
        mWireFrame.initFragment()
    }

    // ---- END GenericRootActivity ----

}