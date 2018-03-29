package com.glacialware.r15k.view.views.playerDetail

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.databinding.FragmentPlayerDetailBinding
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import com.glacialware.r15k.view.wireframes.playerDetail.PlayerDetailFragmentWireframe
import com.glacialware.r15k.viewmodel.views.playerDetail.IPlayerDetailView
import com.glacialware.r15k.viewmodel.views.playerDetail.PlayerDetailViewModel

/**
 * A placeholder fragment containing a simple view.
 */
class PlayerDetailFragment : GenericRootFragment<PlayerDetailFragmentWireframe, PlayerDetailViewModel, FragmentPlayerDetailBinding>(), IPlayerDetailView {

    // ---- Companion ----

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

    // ---- END Companion ----

    // ---- PlayerDetailFragment ----

    override fun initWireframe() {
        mWireframe = PlayerDetailFragmentWireframe(this)
    }

    override fun initViewModel() {
        if (activity != null) {
            mViewModel = ViewModelProviders.of(activity!!).get(PlayerDetailViewModel::class.java)
            mViewModel?.playerDetailView = this
        }
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?): View? {
        mBinding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        if (mViewModel != null) {
            mBinding.viewModel = mViewModel as PlayerDetailViewModel
        }
        return mBinding.root
    }

    override fun clear() {
        mBinding.unbind()
    }

    override fun initComponents() {

    }

    // ---- END PlayerDetailFragment ----

    // ---- IPlayerDetailView ----

    override fun finishDeletePlayer() {
        this.activity?.finish()
    }

    // ---- END IPlayerDetailView ----

}
