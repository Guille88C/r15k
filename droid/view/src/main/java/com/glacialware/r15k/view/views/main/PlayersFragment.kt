package com.glacialware.r15k.view.views.main

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.databinding.FragmentPlayersBinding
import com.glacialware.r15k.view.presenters.main.PlayersFragmentPresenter
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import com.glacialware.r15k.view.wireframes.main.PlayersFragmentWireframe
import com.glacialware.r15k.viewmodel.views.main.MainViewModel
import kotlinx.android.synthetic.main.fragment_players.*

/**
* Created by Guille on 09/07/2017.
*/
class PlayersFragment : GenericRootFragment() {

    // ---- Companion ----

    companion object {
        val TAG : String = this :: class.java.canonicalName

        fun newInstance() : PlayersFragment {
            val f = PlayersFragment()
            val args = Bundle()
            f.arguments = args
            return f
        }
    }

    // ---- END Companion ----

    // ---- Attributes ----

    private var mPlayersAdapter : PlayersAdapter? = null

    // ---- END Attributes ----

    // ---- GenericRootFragment ----

    override fun initWireframe() {
        mWireframe = PlayersFragmentWireframe(this)
    }

    override fun initPresenter() {
        mPresenter = PlayersFragmentPresenter()
    }

    override fun initViewModel() {
        if (activity != null) {
            mViewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        }
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?): View? {
        mBinding = FragmentPlayersBinding.inflate(inflater, container, false)
        if (mViewModel != null) {
            (mBinding as FragmentPlayersBinding).viewModel = mViewModel as MainViewModel
        }
        return mBinding.root
    }

    override fun clear() {
        mBinding.unbind()
        lifecycle.removeObserver(mViewModel as LifecycleObserver)
    }

    override fun initComponents() {
        if (mViewModel != null) {
            if (mViewModel is LifecycleObserver) {
                lifecycle.addObserver(mViewModel as LifecycleObserver)
            }

            if (mPlayersAdapter == null && mViewModel is MainViewModel) {
                rvPlayers.layoutManager = LinearLayoutManager(activity)
                this.mPlayersAdapter = PlayersAdapter(mViewModel as MainViewModel)
                rvPlayers.adapter = this.mPlayersAdapter
            }
            else {
                mPlayersAdapter?.update()
            }

            if (mViewModel is MainViewModel) {
                (mViewModel as MainViewModel).lPlayers.observe(
                        {
                            lifecycle
                        },
                        { _ ->
                            mPlayersAdapter?.update()
                        }
                )
            }
        }
    }

    // ---- END GenericRootFragment ----

}