package com.glacialware.r15k.view.views.cardDetail

import android.arch.lifecycle.ViewModelProviders
import android.view.MenuItem
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.di.ActivityDependency
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import com.glacialware.r15k.view.wireframes.Wireframe
import com.glacialware.r15k.viewmodel.views.cardDetail.CardDetailViewModel

/**
* Created by Guille on 09/07/2017.
*/
class CardDetailActivity : GenericRootActivity<CardDetailViewModel>(true) {

    // ---- Attributes ----
    private val mWireFrame = ActivityDependency.provideEditCardWireframe(this)
    // ---- END Attributes ----

    // ---- GenericRootActivity ----

    override fun initDI() {
    }

    override fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(CardDetailViewModel::class.java)
    }

    override fun initView() {
        this.setContentView(R.layout.activity_generic_toolbar)
    }

    override fun initFragment() {
        Wireframe.navigateTo(supportFragmentManager, CardDetailFragment.newInstance(), CardDetailFragment.TAG, R.id.frame_content, true, false)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> this.onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    // ---- END GenericRootActivity ----
}