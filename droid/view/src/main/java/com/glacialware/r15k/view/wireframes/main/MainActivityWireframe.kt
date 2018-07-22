package com.glacialware.r15k.view.wireframes.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.test.TestActivity
import com.glacialware.r15k.view.views.addPlayer.AddPlayerActivity
import com.glacialware.r15k.view.views.cards.CardsActivity
import com.glacialware.r15k.view.views.main.PlayersFragment
import com.glacialware.r15k.view.wireframes.generic.GenericActivityWireframe

/**
* Created by maric on 11/08/2017.
*/
class MainActivityWireframe(view : AppCompatActivity) : GenericActivityWireframe(view) {

    override fun initFragment() {
        mActivity.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.activity_main_content_frame, PlayersFragment.newInstance())
                ?.commit()
    }

    fun goToStartGame() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun goToTest() {
        val intent = Intent(mActivity, TestActivity::class.java)
        mActivity.startActivity(intent)
    }

    fun goToAddPlayer() {
        val intent = Intent(mActivity, AddPlayerActivity :: class.java)
        mActivity.startActivity(intent)
    }

    fun goToCards() {
        val intent = Intent(mActivity, CardsActivity :: class.java)
        mActivity.startActivity(intent)
    }

    fun goToTestActivity() {
        val intent = Intent(mActivity, TestActivity:: class.java)
        mActivity.startActivity(intent)
    }

    // ---- END Public ----

}