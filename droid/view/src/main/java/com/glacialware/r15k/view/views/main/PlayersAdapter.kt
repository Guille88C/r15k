package com.glacialware.r15k.view.views.main

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.view.databinding.ViewMainPlayersItemBinding
import com.glacialware.r15k.view.presenters.main.PlayersFragmentPresenter

/**
* Created by Guille on 13/11/2017.
*/
class PlayersAdapter(private val mPlayersPresenter: PlayersFragmentPresenter,
                     private val lPlayers : MutableList<Player>)
    : RecyclerView.Adapter<PlayersAdapter.PlayersVH>() {

    // ---- Diff ----

    class PlayersDiffCallback(private val lOld : List<Player>, val lNew : List<Player>) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
                = (lOld[oldItemPosition].id == lNew[newItemPosition].id)

        override fun getOldListSize(): Int = lOld.size

        override fun getNewListSize(): Int = lNew.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
                = (lOld[oldItemPosition] == lNew[newItemPosition])
    }

    // ---- END Diff ----

    // ---- Holder ----

    class PlayersVH(private val mPlayersPresenter: PlayersFragmentPresenter, private val binding: ViewMainPlayersItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private var player: Player? = null

        fun bind(player : Player) {
            binding.player = player
            binding.presenter = mPlayersPresenter
            binding.executePendingBindings()

            this.player = player
        }
    }

    // ---- END Holder ----

    // ---- Adapter ----

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlayersAdapter.PlayersVH {
        val inflater = LayoutInflater.from(parent?.context)
        val itemBinding = ViewMainPlayersItemBinding.inflate(inflater, parent, false)
        return PlayersVH(mPlayersPresenter, itemBinding)
    }

    override fun getItemCount(): Int = lPlayers.size

    override fun onBindViewHolder(holder: PlayersAdapter.PlayersVH?, position: Int) {
        val player = this.lPlayers[position]
        holder?.bind(player)
    }

    // ---- END Adapter ----

    // ---- Public ----

    fun update(newList : List<Player>) {
        val diffResult = DiffUtil.calculateDiff(PlayersDiffCallback(lPlayers, newList))
        lPlayers.clear()
        lPlayers.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    // ---- END Public ----

}