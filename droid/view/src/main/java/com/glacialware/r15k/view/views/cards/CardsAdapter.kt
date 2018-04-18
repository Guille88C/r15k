package com.glacialware.r15k.view.views.cards

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.databinding.ViewCardsItemBinding
import com.glacialware.r15k.viewmodel.model.Mission
import com.glacialware.r15k.viewmodel.views.cards.CardsViewModel

class CardsAdapter(private val mCardsViewModel: CardsViewModel): RecyclerView.Adapter<CardsAdapter.CardsViewHolder>() {

    // ---- Attributes ----
    var mBinding: ViewCardsItemBinding? = null
    // ---- END Attributes ----

    // ---- ViewHolder ----
    inner class CardsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(mission: Mission?) {
            mBinding?.mission = mission
            mBinding?.executePendingBindings()
        }
    }
    // ---- END ViewHolder ----

    // ---- RecyclerView.Adapter ----
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        mBinding = ViewCardsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return if (mBinding != null) {
            CardsViewHolder(mBinding!!.root)
        }
        else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.view_cards_item, parent, false)
            CardsViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        holder.bind(mCardsViewModel.lMissions.value?.get(position))
    }

    override fun getItemCount() = mCardsViewModel.lMissions.value?.size ?: 0
    // ---- END RecyclerView.Adapter ----

    // ---- Public ----
    fun clear() {
        mBinding?.unbind()
    }
    // ---- END Public
}