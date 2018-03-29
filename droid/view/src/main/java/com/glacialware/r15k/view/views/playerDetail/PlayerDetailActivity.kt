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

class PlayerDetailActivity : GenericRootActivity(true) {

    // ---- GenericRootActivity ----

    override fun initPresenter() {
    }

    override fun initWireframe() {
        mWireFrame = PlayerDetailActivityWireframe(this)
    }

    override fun initFragment() {
        mWireFrame.initFragment()
    }

    override fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(PlayerDetailViewModel::class.java)
        val player = intent.getParcelableExtra<Player>(PLAYER)
        (mViewModel as PlayerDetailViewModel).player = player
    }

    override fun initView() {
        setContentView(R.layout.activity_generic_toolbar)
        this.initToolbar()
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
