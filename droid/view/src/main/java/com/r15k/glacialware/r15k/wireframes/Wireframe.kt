package com.r15k.glacialware.r15k.wireframes

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.r15k.glacialware.r15k.R

/**
 * Created by Guille on 06/07/2017.
 */
fun navigateTo(activity : AppCompatActivity, cls : Class<*>) {
    val intent = Intent(activity, cls)
    activity.startActivity(intent)
}

fun navigateBackAnimated(activity : AppCompatActivity) {
    activity.overridePendingTransition(R.anim.slide_in_exit, R.anim.slide_out_exit)
}

fun navigateTo(fm : FragmentManager, fragment : Fragment, fragmentTag : String, idContainer : Int, init : Boolean, animation : Boolean) {
    val ft : FragmentTransaction = fm.beginTransaction()

    if (animation)
        ft.setCustomAnimations(R.anim.slide_fragment_in_enter, R.anim.slide_fragment_out_enter, R.anim.slide_fragment_in_exit, R.anim.slide_fragment_out_exit)

    ft.replace(idContainer, fragment)

    if (!init)
        ft.addToBackStack(fragmentTag)

    ft.commit()
}