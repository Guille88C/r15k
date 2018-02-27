package com.glacialware.r15k.view.views.editCard

import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.wireframes.navigateTo
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
* Created by Guille on 09/07/2017.
*/
class EditCardActivity : GenericRootActivity(true) {

    // ---- Activity ----

    override fun initViewModel() {
    }

    override fun initView() {
        this.setContentView(R.layout.activity_generic_toolbar)

        this.initToolbar()
    }

    override fun initFragment() {
        navigateTo(supportFragmentManager, EditCardFragment.newInstance(), EditCardFragment.TAG, R.id.frame_content, true, false)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> this.onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    // ---- END Activity ----

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