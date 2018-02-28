package com.glacialware.r15k.view.wireframes.main

import android.content.Intent
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.TestActivity
import com.glacialware.r15k.view.views.addPlayer.AddPlayerActivity
import com.glacialware.r15k.view.views.editCard.EditCardActivity
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import com.glacialware.r15k.view.views.main.PlayersFragment

/**
* Created by maric on 11/08/2017.
*/
class MainWireframe(private val activity : GenericRootActivity?) {

    // ---- Public ----
    fun startFragment() {
        activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.activity_main_content_frame, PlayersFragment.newInstance())
                ?.commit()
    }

    fun goToStartGame() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun goToTest() {
        val intent = Intent(activity, TestActivity ::class.java)
        activity?.startActivity(intent)
    }

    fun goToAddPlayer() {
        val intent = Intent(activity, AddPlayerActivity :: class.java)
        activity?.startActivity(intent)
    }

    fun goToEditCard() {
        val intent = Intent(activity, EditCardActivity :: class.java)
        activity?.startActivity(intent)
    }

    fun goToTestActivity() {
        val intent = Intent(activity, TestActivity :: class.java)
        activity?.startActivity(intent)
    }

    // ---- END Public ----

}