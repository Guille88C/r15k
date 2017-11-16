package com.glacialware.r15k.view.Components

import android.content.Context
import android.widget.Toast
import com.glacialware.r15k.viewmodel.Interfaces.ICustomToast

/**
 * Created by Guille on 16/11/2017.
 */
class CustomToast(private val context : Context) : ICustomToast {
    override fun startToast(sText: String) {
        Toast.makeText(context, sText, Toast.LENGTH_LONG).show()
    }
}