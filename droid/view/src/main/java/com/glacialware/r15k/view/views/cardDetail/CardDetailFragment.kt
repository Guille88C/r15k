package com.glacialware.r15k.view.views.cardDetail

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.databinding.FragmentCardDetailBinding
import com.glacialware.r15k.view.views.di.FragmentDependency
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import com.glacialware.r15k.viewmodel.views.cardDetail.CardDetailViewModel

/**
* Created by Guille on 10/07/2017.
*/
class CardDetailFragment : GenericRootFragment<CardDetailViewModel, FragmentCardDetailBinding>() {

    // ---- Companion ----
    companion object {
        val TAG : String = this :: class.java.canonicalName

        fun newInstance() : CardDetailFragment {
            val f = CardDetailFragment()
            val args = Bundle()
            f.arguments = args
            return f
        }
    }

    // ---- END Companion ----

    // ---- Attributes ----
    private val mWireframe = FragmentDependency.provideEditCardWireframe(this)
    // ---- END Attributes ----

    // ---- GenericRootFragment ----

    override fun initDI() {
    }

    override fun initViewModel() {
        if (activity != null) {
            mViewModel = ViewModelProviders.of(activity!!).get(CardDetailViewModel::class.java)
        }
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?): View? {
        mBinding = FragmentCardDetailBinding.inflate(inflater, container, false)
        mBinding.viewModel = mViewModel
        return mBinding.root
    }

    override fun clear() {
        mBinding.unbind()
    }

    override fun initComponents() {

    }

    // ---- END GenericRootFragment ----

}