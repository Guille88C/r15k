package com.glacialware.r15k.view.views.main

import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.databinding.ViewMainPlayersItemBinding

/**
 * Created by Guille on 13/11/2017.
 */
class PlayersAdapter(private var lPlayers : List<Player>) : RecyclerView.Adapter<PlayersAdapter.PlayersVH>() {
    class PlayersDiffCallback(val lOld : List<Player>, val lNew : List<Player>) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = (lOld[oldItemPosition].id == lNew[newItemPosition].id)
        override fun getOldListSize(): Int = lOld.size
        override fun getNewListSize(): Int = lNew.size
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = (lOld[oldItemPosition] == lNew[newItemPosition])
    }

    class PlayersVH(private val binding : ViewMainPlayersItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(player : Player) {
            binding.player = player
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlayersAdapter.PlayersVH{
        val inflater = LayoutInflater.from(parent?.context)
        val itemBinding = DataBindingUtil.inflate<ViewMainPlayersItemBinding>(inflater, R.layout.view_main_players_item, parent, false)
        return PlayersVH(itemBinding)
    }

    override fun getItemCount(): Int = lPlayers.size

    override fun onBindViewHolder(holder: PlayersAdapter.PlayersVH?, position: Int) {
        val player = this.lPlayers[position]
        holder?.bind(player)
    }

    fun update(newList : List<Player>) {
        val diffResult = DiffUtil.calculateDiff(PlayersDiffCallback(lPlayers, newList))
        diffResult.dispatchUpdatesTo(this)
    }
}