package com.glacialware.r15k.view.views.main

import android.arch.lifecycle.*
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.presenters.main.PlayersPresenter
import com.glacialware.r15k.view.presenters.main.PlayersPresenterImpl
import com.glacialware.r15k.viewmodel.views.main.PlayersViewModel
import kotlinx.android.synthetic.main.fragment_players.*

/**
 * Created by Guille on 09/07/2017.
 */
class PlayersFragment : Fragment(), IPlayerClick {
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

    private lateinit var presenter : PlayersPresenter
    private lateinit var mPlayersVM : PlayersViewModel
    private var mPlayersAdapter : PlayersAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // view model
        this.mPlayersVM = ViewModelProviders.of(this).get(PlayersViewModel::class.java)
        this.lifecycle.addObserver(this.mPlayersVM)
        // ----

        return inflater?.inflate(R.layout.fragment_players, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = PlayersPresenterImpl(this)
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
        if (mPlayersAdapter == null) {
            this.rvPlayers.layoutManager = LinearLayoutManager(this.activity)
            this.mPlayersAdapter = PlayersAdapter(lItems as MutableList<Player>)
            this.rvPlayers.adapter = this.mPlayersAdapter

            this.mPlayersAdapter?.itemClick = this
        }
        else {
            mPlayersAdapter?.update(lItems)
        }
    }

    override fun onPlayerClick(item: Player) {
        if (presenter != null) {
            presenter.onItemPlayerClick(item)
        }
    }
}