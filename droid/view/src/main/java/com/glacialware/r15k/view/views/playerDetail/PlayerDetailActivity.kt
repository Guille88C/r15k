package com.glacialware.r15k.view.views.playerDetail

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import com.glacialware.r15k.view.wireframes.navigateTo
import kotlinx.android.synthetic.main.activity_main.*

class PlayerDetailActivity : GenericRootActivity(true) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generic_toolbar)

        this.initToolbar()
        this.initFragment()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                android.R.id.home -> this.onBackPressed()
            }
        }

        return super.onOptionsItemSelected(item)
    }




    private fun initToolbar() {
        if (myToolbar != null)
            this.setSupportActionBar(myToolbar as Toolbar)

        if (this.supportActionBar != null) {
            (this.supportActionBar as ActionBar).setDisplayHomeAsUpEnabled(true)
            (this.supportActionBar as ActionBar).setHomeButtonEnabled(true)
        }
    }

    private fun initFragment() {
        navigateTo(supportFragmentManager, PlayerDetailFragment.newInstance(), PlayerDetailFragment.TAG, R.id.frame_content, true, false)
    }
}
