package com.glacialware.r15k.view.views.playerDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.generic.GenericRootFragment

/**
 * A placeholder fragment containing a simple view.
 */
class PlayerDetailFragment : GenericRootFragment() {
    companion object {
        @JvmStatic
        val TAG : String = this :: class.java.canonicalName

        @JvmStatic
        fun newInstance() : PlayerDetailFragment {
            val f = PlayerDetailFragment()
            val args = Bundle()
            f.arguments = args
            return f
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_player_detail, container, false)
    }
}
