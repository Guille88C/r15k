package com.glacialware.r15k.view.wireframes.main

import android.content.Intent
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.TestActivity
import com.glacialware.r15k.view.views.addPlayer.AddPlayerActivity
import com.glacialware.r15k.view.views.addPlayer.EditCardActivity
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import com.glacialware.r15k.view.views.main.PlayersFragment

/**
 * Created by maric on 11/08/2017.
 */
class MainWireframeImpl(private val activity : GenericRootActivity?) : MainWireframe {
    override fun startFragment() {
        activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.activity_main_content_frame, PlayersFragment.newInstance())
                ?.commit()
    }

    override fun goToStartGame() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToTest() {
        val intent = Intent(activity, TestActivity ::class.java)
        activity?.startActivity(intent)
    }

    override fun goToAddPlayer() {
        val intent = Intent(activity, AddPlayerActivity :: class.java)
        activity?.startActivity(intent)
    }

    override fun goToEditCard() {
        val intent = Intent(activity, EditCardActivity :: class.java)
        activity?.startActivity(intent)
    }
}