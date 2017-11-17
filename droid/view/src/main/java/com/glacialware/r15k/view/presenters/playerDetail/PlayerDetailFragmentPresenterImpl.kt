package com.glacialware.r15k.view.presenters.playerDetail

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.databinding.FragmentPlayerDetailBinding
import com.glacialware.r15k.view.views.playerDetail.PlayerDetailFragment
import com.glacialware.r15k.viewmodel.views.playerDetail.PlayerDetailViewModel

/**
 * Created by Guille on 17/11/2017.
 */
class PlayerDetailFragmentPresenterImpl(private val view: PlayerDetailFragment) : PlayerDetailFragmentPresenter {
    private var viewModel: PlayerDetailViewModel? = null

    override fun initViewModel(inflater: LayoutInflater, container: ViewGroup) : View? {
        this.viewModel = ViewModelProviders.of(view.activity).get(PlayerDetailViewModel::class.java)
        if (this.viewModel != null && this.viewModel?.player != null) {
            val binding = DataBindingUtil.inflate<FragmentPlayerDetailBinding>(inflater, R.layout.fragment_player_detail, container, false)
            binding.player = viewModel?.player
            return binding.root
        }
        return null
    }
}