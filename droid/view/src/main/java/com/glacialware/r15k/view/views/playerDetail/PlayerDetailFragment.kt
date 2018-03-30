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
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class PlayerDetailFragment : GenericRootFragment<PlayerDetailViewModel, FragmentPlayerDetailBinding>(), IPlayerDetailView {

    // ---- Companion ----

    companion object {
        val TAG : String = this :: class.java.canonicalName

        fun newInstance() : PlayerDetailFragment {
            val f = PlayerDetailFragment()
            val args = Bundle()
            f.arguments = args
            return f
        }
    }

    // ---- END Companion ----

    // ---- Dagger attributes ----
    @field:[Inject]
    protected lateinit var mWireframe: PlayerDetailFragmentWireframe
    // ---- END Dagger attributes ----

    // ---- PlayerDetailFragment ----

    override fun initDI() {
        mFragmentComponent.inject(this)
    }

    override fun initViewModel() {
        if (activity != null) {
            mViewModel = ViewModelProviders.of(activity!!).get(PlayerDetailViewModel::class.java)
            mViewModel.playerDetailView = this
        }
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?): View? {
        mBinding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        mBinding.viewModel = mViewModel
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
