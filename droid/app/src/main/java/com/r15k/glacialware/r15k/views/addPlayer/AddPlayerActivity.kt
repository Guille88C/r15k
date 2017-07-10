package com.r15k.glacialware.r15k.views.addPlayer

import android.support.v7.widget.Toolbar
import com.r15k.glacialware.r15k.R
import com.r15k.glacialware.r15k.rooting.navigateTo
import com.r15k.glacialware.r15k.views.generic.GenericRootActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Guille on 09/07/2017.
 */
class AddPlayerActivity : GenericRootActivity(true) {
    override fun inflateLayout() {
        this.setContentView(R.layout.activity_add_player)
    }

    override fun init() {
        this.initToolbar()
        this.initFragment()
    }

    private fun initToolbar() {
        if (myToolbar != null)
            this.setSupportActionBar(myToolbar as Toolbar)
    }

    private fun initFragment() {
        navigateTo(supportFragmentManager, AddPlayerFragment.newInstance(), AddPlayerFragment.TAG, R.id.activity_add_player_content_frame, true, false)
    }
}