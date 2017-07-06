package com.r15k.glacialware.r15k.rooting

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.r15k.glacialware.r15k.R

/**
 * Created by Guille on 06/07/2017.
 */
fun navigateTo(activity : AppCompatActivity, cls : Class<*>) {
    var intent = Intent(activity, cls)
    activity.startActivity(intent)
}

fun navigateBackAnimated(activity : AppCompatActivity) {
    activity.overridePendingTransition(R.anim.slide_in_exit, R.anim.slide_out_exit)
}