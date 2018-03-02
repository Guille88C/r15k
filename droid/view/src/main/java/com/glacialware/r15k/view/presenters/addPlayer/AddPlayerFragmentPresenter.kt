package com.glacialware.r15k.view.presenters.addPlayer

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.components.CustomToast
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.databinding.FragmentAddPlayerBinding
import com.glacialware.r15k.view.presenters.GenericFragmentPresenter
import com.glacialware.r15k.view.views.addPlayer.AddPlayerFragment
import com.glacialware.r15k.viewmodel.views.addPlayer.AddPlayerViewModel
import javax.inject.Inject

/**
* Created by Guille on 20/11/2017.
*/
class AddPlayerFragmentPresenter(view: AddPlayerFragment) : GenericFragmentPresenter(view) {

    // ---- Attributes ----

    private var viewModel : AddPlayerViewModel? = null
    private var binding : FragmentAddPlayerBinding? = null

    // ---- END Attributes ----

    // ---- FragmentPresenter ----

    override fun initViewModel(inflater: LayoutInflater, container: ViewGroup): View? {
        // view model
        if (mView.activity != null) {
            viewModel = ViewModelProviders.of(mView.activity!!).get(AddPlayerViewModel::class.java)
        }
        if (viewModel != null) {
            mView.lifecycle.addObserver(viewModel!!)
            // ----
            // data binding
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_player, container, false)
            if (binding != null) {
                binding?.viewModel = viewModel
                // ----
                return binding?.root
            }
        }

        return null
    }

    // ---- END FragmentPresenter ----
}