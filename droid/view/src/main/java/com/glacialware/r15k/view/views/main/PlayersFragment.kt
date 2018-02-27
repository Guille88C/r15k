package com.glacialware.r15k.view.views.main

import android.os.Bundle
import android.view.View
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.view.presenters.main.PlayersFragmentPresenter
import com.glacialware.r15k.view.views.generic.GenericRootFragment

/**
* Created by Guille on 09/07/2017.
*/
class PlayersFragment : GenericRootFragment() {

    // ---- Companion ----

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

    // ---- END Companion ----

    // ---- Fragment ----

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (this.presenter != null && this.presenter is PlayersFragmentPresenter) {
            (this.presenter as PlayersFragmentPresenter).initPlayersObserver()
        }
    }

    // ---- END Fragment ----

    // ---- Constructor ----

    init {
        this.presenter = PlayersFragmentPresenter(this)
    }

    // ---- END Constructor ----

}