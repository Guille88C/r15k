package com.glacialware.r15k.view.views.addPlayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.presenters.addPlayer.AddPlayerFragmentPresenter
import com.glacialware.r15k.view.views.generic.GenericRootFragment

/**
 * Created by Guille on 10/07/2017.
 */
class AddPlayerFragment : GenericRootFragment() {
    companion object {
        @JvmStatic
        val TAG : String = this :: class.java.canonicalName

        @JvmStatic
        fun newInstance() : AddPlayerFragment {
            val f = AddPlayerFragment()
            val args = Bundle()
            f.arguments = args
            return f
        }
    }

    private val presenter = AddPlayerFragmentPresenter(this)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (inflater != null && container != null) {
            return presenter.initViewModel(inflater, container)
        }

        return null
    }
}