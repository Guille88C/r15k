package com.glacialware.r15k.view.views.playerDetail

import android.arch.lifecycle.ViewModelProviders
import android.view.MenuItem
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.di.ActivityDependency
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import com.glacialware.r15k.view.wireframes.Constants
import com.glacialware.r15k.viewmodel.model.Player
import com.glacialware.r15k.viewmodel.views.playerDetail.PlayerDetailViewModel

class PlayerDetailActivity : GenericRootActivity<PlayerDetailViewModel>(true) {

    // ---- Attributes ----
    private val mWireFrame = ActivityDependency.providePlayerDetailWireframe(this)
    // ---- END Attributes ----

    // ---- GenericRootActivity ----

    override fun initDI() {
    }

    override fun initFragment() {
        mWireFrame.initFragment()
    }

    override fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(PlayerDetailViewModel::class.java)
        val player = intent.getParcelableExtra<Player>(Constants.PLAYER)
        mViewModel.player = player
    }

    override fun initView() {
        setContentView(R.layout.activity_generic_toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                android.R.id.home -> this.onBackPressed()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    // ---- END GenericRootActivity ----

}
