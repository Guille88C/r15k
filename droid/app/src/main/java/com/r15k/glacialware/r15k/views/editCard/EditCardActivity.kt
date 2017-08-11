package com.r15k.glacialware.r15k.views.addPlayer

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.r15k.glacialware.r15k.R
import com.r15k.glacialware.r15k.wireframes.navigateTo
import com.r15k.glacialware.r15k.views.generic.GenericRootActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Guille on 09/07/2017.
 */
class EditCardActivity : GenericRootActivity(true) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_edit_card)

        this.initToolbar()
        this.initFragment()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> this.onBackPressed()
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
        navigateTo(supportFragmentManager, EditCardFragment.newInstance(), EditCardFragment.TAG, R.id.frame_content, true, false)
    }
}