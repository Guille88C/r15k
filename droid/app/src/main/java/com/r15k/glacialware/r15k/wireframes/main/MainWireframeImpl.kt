package com.r15k.glacialware.r15k.wireframes.main

import android.app.Activity
import android.content.Intent
import com.r15k.glacialware.r15k.views.TestActivity
import com.r15k.glacialware.r15k.views.addPlayer.AddPlayerActivity
import com.r15k.glacialware.r15k.views.addPlayer.EditCardActivity

/**
 * Created by maric on 11/08/2017.
 */
class MainWireframeImpl(private val activity : Activity?) : MainWireframe {
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