package com.glacialware.r15k.view.views.main

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.databinding.ViewMainPlayersItemBinding
import com.glacialware.r15k.view.entities.Player

/**
 * Created by Guille on 13/11/2017.
 */
class PlayersAdapter(val lPlayers : ArrayList<Player>) : RecyclerView.Adapter<PlayersAdapter.PlayersVH>() {
    class PlayersVH(val binding : ViewMainPlayersItemBinding) : RecyclerView.ViewHolder(binding.root) {
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

    override fun getItemCount(): Int {
        return lPlayers.size
    }

    override fun onBindViewHolder(holder: PlayersAdapter.PlayersVH?, position: Int) {
        val player = this.lPlayers[position]
        holder?.bind(player)
    }
}