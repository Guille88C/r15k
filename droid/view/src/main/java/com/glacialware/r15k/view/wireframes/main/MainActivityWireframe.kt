package com.glacialware.r15k.view.wireframes.main

import android.content.Intent
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.TestActivity
import com.glacialware.r15k.view.views.addPlayer.AddPlayerActivity
import com.glacialware.r15k.view.views.editCard.EditCardActivity
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import com.glacialware.r15k.view.views.main.PlayersFragment
import com.glacialware.r15k.view.wireframes.generic.GenericActivityWireframe

/**
* Created by maric on 11/08/2017.
*/
class MainActivityWireframe(view : GenericRootActivity) : GenericActivityWireframe(view) {

    override fun initFragment() {
        mActivity.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.activity_main_content_frame, PlayersFragment.newInstance())
                ?.commit()
    }

    fun goToStartGame() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun goToTest() {
        val intent = Intent(mActivity, TestActivity ::class.java)
        mActivity.startActivity(intent)
    }

    fun goToAddPlayer() {
        val intent = Intent(mActivity, AddPlayerActivity :: class.java)
        mActivity.startActivity(intent)
    }

    fun goToEditCard() {
        val intent = Intent(mActivity, EditCardActivity :: class.java)
        mActivity.startActivity(intent)
    }

    fun goToTestActivity() {
        val intent = Intent(mActivity, TestActivity :: class.java)
        mActivity.startActivity(intent)
    }

    // ---- END Public ----

}