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
class PlayersAdapter(private var lPlayers : MutableList<Player>) : RecyclerView.Adapter<PlayersAdapter.PlayersVH>(), IPlayerClick {
    class PlayersDiffCallback(val lOld : List<Player>, val lNew : List<Player>) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = (lOld[oldItemPosition].id == lNew[newItemPosition].id)
        override fun getOldListSize(): Int = lOld.size
        override fun getNewListSize(): Int = lNew.size
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = (lOld[oldItemPosition] == lNew[newItemPosition])
    }

    class PlayersVH : RecyclerView.ViewHolder {
        var itemClick : IPlayerClick? = null
        private val binding: ViewMainPlayersItemBinding
        private var player: Player? = null

        constructor(binding: ViewMainPlayersItemBinding) : super(binding.root) {
            this.binding = binding

            this.binding.root.setOnClickListener {
                item ->
                if (player != null && itemClick != null) {
                    itemClick?.onPlayerClick(player!!)
                }
            }
        }

        fun bind(player : Player) {
            binding.player = player
            binding.executePendingBindings()

            this.player = player
        }
    }

    var itemClick: IPlayerClick? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlayersAdapter.PlayersVH{
        val inflater = LayoutInflater.from(parent?.context)
        val itemBinding = DataBindingUtil.inflate<ViewMainPlayersItemBinding>(inflater, R.layout.view_main_players_item, parent, false)
        val playersVH = PlayersVH(itemBinding)
        playersVH.itemClick = this
        return playersVH
    }

    override fun getItemCount(): Int = lPlayers.size

    override fun onBindViewHolder(holder: PlayersAdapter.PlayersVH?, position: Int) {
        val player = this.lPlayers[position]
        holder?.bind(player)
    }

    fun update(newList : List<Player>) {
        val diffResult = DiffUtil.calculateDiff(PlayersDiffCallback(lPlayers, newList))
        lPlayers.clear()
        lPlayers.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onPlayerClick(item: Player) {
        if (itemClick != null) {
            itemClick?.onPlayerClick(item)
        }
    }
}