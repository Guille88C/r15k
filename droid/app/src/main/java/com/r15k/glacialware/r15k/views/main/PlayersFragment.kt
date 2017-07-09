package com.r15k.glacialware.r15k.views.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.r15k.glacialware.r15k.R
import com.r15k.glacialware.r15k.views.generic.GenericRootFragment

/**
 * Created by Guille on 09/07/2017.
 */
class PlayersFragment : GenericRootFragment() {
    companion object {
        @JvmStatic
        val TAG : String = this :: class.java.canonicalName

        @JvmStatic
        fun newInstance() : PlayersFragment {
            val f = PlayersFragment()
            val args = Bundle()
            f.arguments = args
            return f
        }
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.fragment_players, container, false)
    }
}