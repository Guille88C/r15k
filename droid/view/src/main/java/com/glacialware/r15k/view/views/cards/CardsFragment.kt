package com.glacialware.r15k.view.views.cards

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.databinding.FragmentCardsBinding
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import com.glacialware.r15k.viewmodel.model.Mission
import com.glacialware.r15k.viewmodel.views.cards.CardsViewModel
import kotlinx.android.synthetic.main.fragment_cards.*

/**
 * Created by gcuestab on 2/4/18.
 */
class CardsFragment: GenericRootFragment<CardsViewModel, FragmentCardsBinding>() {
    // ---- Companion ----
    companion object {
        val TAG : String = this :: class.java.canonicalName

        fun newInstance() : CardsFragment {
            val f = CardsFragment()
            val args = Bundle()
            f.arguments = args
            return f
        }
    }
    // ---- END Companion ----

    // ---- Observer ----
    private val mObserver = Observer<MutableList<Mission>> {
        _ ->
        mAdapter?.notifyDataSetChanged()
    }
    // ---- END Observer ----

    // ---- Attributes ----
    private var mAdapter: CardsAdapter? = null
    // ---- END Attributes ----

    // ---- GenericRootFragment ----
    override fun initDI() {
    }

    override fun initViewModel() {
        mViewModel = if (activity != null) {
            ViewModelProviders.of(activity!!).get(CardsViewModel::class.java)
        }
        else {
            ViewModelProviders.of(this).get(CardsViewModel::class.java)
        }
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?): View? {
        mBinding = FragmentCardsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun clear() {
        mBinding.unbind()
        mAdapter?.clear()

        lifecycle.removeObserver(mViewModel)
        mViewModel.ldMissions.removeObserver(mObserver)
        mViewModel.clear()
    }

    override fun initComponents() {
        lifecycle.addObserver(mViewModel)
        mViewModel.ldMissions.observe(this, mObserver)

        mAdapter = CardsAdapter(mViewModel)
        rv_cards?.adapter = mAdapter
        rv_cards?.layoutManager = LinearLayoutManager(context)
    }

    // ---- END GenericRootFragment ----
}