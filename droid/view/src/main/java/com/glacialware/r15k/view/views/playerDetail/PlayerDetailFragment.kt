package com.glacialware.r15k.view.views.playerDetail

import android.os.Bundle
import com.glacialware.r15k.view.presenters.playerDetail.PlayerDetailFragmentPresenter
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import com.glacialware.r15k.viewmodel.views.playerDetail.IPlayerDetailView

/**
 * A placeholder fragment containing a simple view.
 */
class PlayerDetailFragment : GenericRootFragment(), IPlayerDetailView {
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

    init {
        this.presenter = PlayerDetailFragmentPresenter(this)
    }

    override fun finishDeletePlayer() {
        this.activity?.finish()
    }
}
