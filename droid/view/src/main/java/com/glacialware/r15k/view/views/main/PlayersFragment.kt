package com.glacialware.r15k.view.views.main

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.databinding.FragmentPlayersBinding
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import com.glacialware.r15k.view.wireframes.main.PlayersFragmentWireframe
import com.glacialware.r15k.viewmodel.model.Player
import com.glacialware.r15k.viewmodel.views.main.MainViewModel
import com.glacialware.r15k.viewmodel.views.main.PlayersView
import kotlinx.android.synthetic.main.fragment_players.*
import javax.inject.Inject

/**
* Created by Guille on 09/07/2017.
*/
class PlayersFragment : GenericRootFragment<MainViewModel, FragmentPlayersBinding>(), PlayersView {

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

    // ---- Observer ----
    private val mObserver = Observer<MutableList<Player>> {
        mPlayersAdapter?.notifyDataSetChanged()
    }
    // ---- END Observer ----

    // ---- Dagger attributes ----
    @field:[Inject]
    protected lateinit var mWireframe: PlayersFragmentWireframe
    // ---- END Dagger attributes ----

    // ---- GenericRootFragment ----

    override fun initDI() {
        mFragmentComponent.inject(this)
    }

    override fun initViewModel() {
        if (activity != null) {
            mViewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
            mViewModel.setPlayersView(this)
        }
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?): View? {
        mBinding = FragmentPlayersBinding.inflate(inflater, container, false)
        mBinding.viewModel = mViewModel
        return mBinding.root
    }

    override fun clear() {
        mBinding.unbind()
        lifecycle.removeObserver(mViewModel as LifecycleObserver)
        mViewModel.lPlayers.removeObserver(mObserver)
    }

    override fun initComponents() {
        lifecycle.addObserver(mViewModel as LifecycleObserver)

        if (mPlayersAdapter == null) {
            rvPlayers.layoutManager = LinearLayoutManager(activity)
            this.mPlayersAdapter = PlayersAdapter(mViewModel)
            rvPlayers.adapter = this.mPlayersAdapter
        }
        else {
            mPlayersAdapter?.update()
        }


        mViewModel.lPlayers.observe(this, mObserver)
    }

    // ---- END GenericRootFragment ----

    // ---- PlayersView ----

    override fun showPlayerDetail(player: Player) {
        mWireframe.goToPlayerDetail(player)
    }

    // ---- END PlayersView ----
}