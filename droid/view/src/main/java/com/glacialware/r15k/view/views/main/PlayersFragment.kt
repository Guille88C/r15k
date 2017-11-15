package com.glacialware.r15k.view.views.main

import android.arch.lifecycle.*
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import com.glacialware.r15k.viewmodel.views.main.PlayersViewModel
import kotlinx.android.synthetic.main.fragment_players.*

/**
 * Created by Guille on 09/07/2017.
 */
class PlayersFragment : GenericRootFragment() {
    companion object {
        @JvmStatic
        val TAG : String = this :: class.java.canonicalName

        @JvmStatic
        fun newInstance() : PlayersFragment {
            val f = PlayersFragment()
            val args = Bundle()
            f.arguments = args
            return f
        }
    }

    lateinit var mPlayersVM : PlayersViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.mPlayersVM = ViewModelProviders.of(this).get(PlayersViewModel::class.java)
        this.lifecycle.addObserver(this.mPlayersVM)

        return inflater?.inflate(R.layout.fragment_players, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.initPlayersObserver()
    }

    fun initPlayersObserver() {
        this.mPlayersVM.lPlayers.observe(
                {
                    this.lifecycle
                },
                {
                    lItems ->
                    if (lItems != null) {
                        this.initPlayers(lItems)
                    }
                }
        )

//        this.mPlayersVM.ListPlayers.observe(this, Observer<ArrayList<Player>> { lItemsObserver ->
//            if (lItemsObserver != null) {
//                this.initPlayers(lItemsObserver)
//            }
//        })
    }

    fun initPlayers(lItems : List<Player>) {
        this.rvPlayers.layoutManager = LinearLayoutManager(this.activity)
        val adapter = PlayersAdapter(lItems)
        this.rvPlayers.adapter = adapter
    }
}