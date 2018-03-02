package com.glacialware.r15k.view.presenters.main

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.presenters.GenericFragmentPresenter
import com.glacialware.r15k.view.views.main.PlayersAdapter
import com.glacialware.r15k.view.views.main.PlayersFragment
import com.glacialware.r15k.view.wireframes.main.PlayersWireframe
import com.glacialware.r15k.viewmodel.views.main.PlayersViewModel
import kotlinx.android.synthetic.main.fragment_players.*

/**
* Created by Guille on 16/11/2017.
*/
class PlayersFragmentPresenter(private val view : PlayersFragment) : GenericFragmentPresenter(view) {

    // ---- Attributes ----

    private var viewModel: PlayersViewModel? = null
    private val wireframe : PlayersWireframe = PlayersWireframe(view)
    private var mPlayersAdapter : PlayersAdapter? = null

    // ---- END Attributes ----

    // ---- FragmentPresenter ----

    override fun initViewModel(inflater: LayoutInflater, container: ViewGroup): View? {
        if (view.activity != null) {
            this.viewModel = ViewModelProviders.of(view.activity!!).get(PlayersViewModel::class.java)
            if (this.viewModel != null) {
                view.lifecycle.addObserver(this.viewModel!!)
            }
        }
        return inflater.inflate(R.layout.fragment_players, container, false)
    }

    // ---- END FragmentPresenter ----

    // ---- Public ----

    fun onItemPlayerClick(player: Player) {
        wireframe.goToPlayerDetail(player)
    }

    fun initPlayersObserver() {
        if (this.viewModel != null && this.viewModel?.lPlayers != null) {
            this.viewModel?.lPlayers?.observe(
                {
                    view.lifecycle
                },
                { lItems ->
                    if (lItems != null) {
                        this.initPlayers(lItems)
                    }
                }
            )
        }
    }

    // ---- END Public ----

    // ---- Private ----

    private fun initPlayers(lItems : List<Player>) {
        if (mPlayersAdapter == null) {
            view.rvPlayers.layoutManager = LinearLayoutManager(view.activity)
            this.mPlayersAdapter = PlayersAdapter(this, lItems as MutableList<Player>)
            view.rvPlayers.adapter = this.mPlayersAdapter
        }
        else {
            mPlayersAdapter?.update(lItems)
        }
    }

    // ---- END Private ----

}