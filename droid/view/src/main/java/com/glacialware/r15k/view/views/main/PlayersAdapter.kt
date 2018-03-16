package com.glacialware.r15k.view.views.main

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.view.databinding.ViewMainPlayersItemBinding
import com.glacialware.r15k.viewmodel.views.main.MainViewModel

/**
* Created by Guille on 13/11/2017.
*/
class PlayersAdapter(private val mViewModel: MainViewModel)
    : RecyclerView.Adapter<PlayersAdapter.PlayersVH>() {

    // ---- Diff ----

    class PlayersDiffCallback(private val lOld : List<Player>, private val lNew : List<Player>) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
                = (lOld[oldItemPosition].id == lNew[newItemPosition].id)

        override fun getOldListSize(): Int = lOld.size

        override fun getNewListSize(): Int = lNew.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
                = (lOld[oldItemPosition] == lNew[newItemPosition])
    }

    // ---- END Diff ----

    // ---- Holder ----

    class PlayersVH(private val mViewModel: MainViewModel, private val binding: ViewMainPlayersItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private var player: Player? = null

        fun bind(player : Player) {
            binding.player = player
            binding.viewModel = mViewModel
            binding.executePendingBindings()

            this.player = player
        }
    }

    // ---- END Holder ----

    // ---- Attributes ----

    private var lPlayers: List<Player> = ArrayList()

    // ---- END Attributes ----

    // ---- Adapter ----

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlayersAdapter.PlayersVH {
        val inflater = LayoutInflater.from(parent?.context)
        val itemBinding = ViewMainPlayersItemBinding.inflate(inflater, parent, false)
        return PlayersVH(mViewModel, itemBinding)
    }

    override fun getItemCount(): Int = lPlayers.size

    override fun onBindViewHolder(holder: PlayersAdapter.PlayersVH?, position: Int) {
        val player = mViewModel.lPlayers.value?.get(position)
        if (player != null) {
            holder?.bind(player)
        }
    }

    // ---- END Adapter ----

    // ---- Public ----

    fun update() {
        if (mViewModel.lPlayers.value != null) {
            val diffResult = DiffUtil.calculateDiff(PlayersDiffCallback(lPlayers, mViewModel.lPlayers.value!!))
            (lPlayers as MutableList).clear()
            (lPlayers as MutableList).addAll(mViewModel.lPlayers.value!!)
            diffResult.dispatchUpdatesTo(this)
        }
    }

    // ---- END Public ----

}