package com.glacialware.r15k.view.views.playerDetail

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import com.glacialware.r15k.view.wireframes.PLAYER
import com.glacialware.r15k.view.wireframes.playerDetail.PlayerDetailActivityWireframe
import com.glacialware.r15k.viewmodel.model.Player
import com.glacialware.r15k.viewmodel.views.playerDetail.PlayerDetailViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class PlayerDetailActivity : GenericRootActivity<PlayerDetailViewModel>(true) {

    // ---- Dagger attributes ----
    @field:[Inject]
    protected lateinit var mWireFrame: PlayerDetailActivityWireframe
    // ---- END Dagger attributes ----

    // ---- GenericRootActivity ----

    override fun initDI() {
        mActivityComponent.inject(this)
    }

    override fun initFragment() {
        mWireFrame.initFragment()
    }

    override fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(PlayerDetailViewModel::class.java)
        val player = intent.getParcelableExtra<Player>(PLAYER)
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
