package com.glacialware.r15k.view.views.addPlayer

import android.os.Bundle
import com.glacialware.r15k.view.presenters.addPlayer.AddPlayerFragmentPresenter
import com.glacialware.r15k.view.views.generic.GenericRootFragment

/**
* Created by Guille on 10/07/2017.
*/
class AddPlayerFragment : GenericRootFragment() {

    // ---- Companion ----

    companion object {
        val TAG : String = this :: class.java.canonicalName

        fun newInstance() : AddPlayerFragment {
            val f = AddPlayerFragment()
            val args = Bundle()
            f.arguments = args
            return f
        }
    }

    // ---- End Companion ----

    // ---- Constructor ----

    init {
        this.presenter = AddPlayerFragmentPresenter(this)
    }

    // ---- END Constructor ----

}