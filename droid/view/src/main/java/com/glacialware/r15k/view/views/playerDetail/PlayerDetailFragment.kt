package com.glacialware.r15k.view.views.playerDetail

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.databinding.FragmentPlayerDetailBinding
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import com.glacialware.r15k.viewmodel.views.playerDetail.PlayerDetailViewModel

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

    lateinit var viewModel : PlayerDetailViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.viewModel = ViewModelProviders.of(this.activity).get(PlayerDetailViewModel::class.java)
        if (inflater != null && this.viewModel.player != null) {
            val binding = DataBindingUtil.inflate<FragmentPlayerDetailBinding>(inflater, R.layout.fragment_player_detail, container, false)
            binding.player = viewModel.player
            return binding.root
        }
        return null
    }
}
