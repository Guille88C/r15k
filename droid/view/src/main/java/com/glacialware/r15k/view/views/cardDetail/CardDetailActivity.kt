package com.glacialware.r15k.view.views.cardDetail

import android.arch.lifecycle.ViewModelProviders
import android.view.MenuItem
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.wireframes.navigateTo
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import com.glacialware.r15k.view.wireframes.cardDetail.CardDetailActivityWireframe
import com.glacialware.r15k.viewmodel.views.cardDetail.CardDetailViewModel
import javax.inject.Inject

/**
* Created by Guille on 09/07/2017.
*/
class CardDetailActivity : GenericRootActivity<CardDetailViewModel>(true) {

    // ---- Dagger attributes ----
    @field:[Inject]
    protected lateinit var mWireFrame: CardDetailActivityWireframe
    // ---- END Dagger attributes ----

    // ---- GenericRootActivity ----

    override fun initDI() {
        mActivityComponent.inject(this)
    }

    override fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(CardDetailViewModel::class.java)
    }

    override fun initView() {
        this.setContentView(R.layout.activity_generic_toolbar)
    }

    override fun initFragment() {
        navigateTo(supportFragmentManager, CardDetailFragment.newInstance(), CardDetailFragment.TAG, R.id.frame_content, true, false)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> this.onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    // ---- END GenericRootActivity ----
}