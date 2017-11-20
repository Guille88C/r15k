package com.glacialware.r15k.view.views.playerDetail

import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.presenters.playerDetail.PlayerDetailActivityPresenter
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import kotlinx.android.synthetic.main.activity_main.*

class PlayerDetailActivity : GenericRootActivity(true) {
    private val presenter: PlayerDetailActivityPresenter = PlayerDetailActivityPresenter(this)

    override fun initFragment() {
        presenter.initFragment()
    }

    override fun initViewModel() {
        presenter.initViewModel()
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

    private fun initToolbar() {
        if (myToolbar != null)
            this.setSupportActionBar(myToolbar as Toolbar)

        if (this.supportActionBar != null) {
            (this.supportActionBar as ActionBar).setDisplayHomeAsUpEnabled(true)
            (this.supportActionBar as ActionBar).setHomeButtonEnabled(true)
        }
    }
}
