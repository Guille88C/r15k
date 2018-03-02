package com.glacialware.r15k.view.components

import android.content.Context
import android.widget.Toast
import com.glacialware.r15k.viewmodel.interfaces.ICustomToast

/**
* Created by Guille on 16/11/2017.
*/
class CustomToast(private val mContext : Context?) : ICustomToast {
    override fun startToast(sText: String) {
        if (mContext != null) {
            Toast.makeText(mContext, sText, Toast.LENGTH_LONG).show()
        }
    }
}