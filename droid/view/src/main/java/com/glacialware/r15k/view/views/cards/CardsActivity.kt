package com.glacialware.r15k.view.views.cards

import android.arch.lifecycle.ViewModelProviders
import android.view.MenuItem
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.di.ActivityDependency
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import com.glacialware.r15k.viewmodel.views.cards.CardsViewModel

/**
 * Created by gcuestab on 2/4/18.
 */
class CardsActivity: GenericRootActivity<CardsViewModel>(true) {

    // ---- Attributes ----
    private val mWireframe = ActivityDependency.provideCardsWireframe(this)
    // ---- END Attributes ----

    // ---- GenericRootActivity ----
    override fun initDI() {
    }

    override fun initFragment() {
        mWireframe.initFragment()
    }

    override fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(CardsViewModel::class.java)
    }

    override fun initView() {
        setContentView(R.layout.activity_generic_toolbar)
    }
    // ---- END GenericRootActivity ----

    // ---- Activity ----
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                android.R.id.home -> this.onBackPressed()
            }
        }

        return super.onOptionsItemSelected(item)
    }
    // ---- END Activity ----
}