package com.glacialware.r15k.view.components

import android.content.Context
import android.widget.Toast
import com.glacialware.r15k.viewmodel.interfaces.ICustomToast

/**
* Created by Guille on 16/11/2017.
*/
class CustomToast(private val context : Context) : ICustomToast {
    override fun startToast(sText: String) {
        Toast.makeText(context, sText, Toast.LENGTH_LONG).show()
    }
}