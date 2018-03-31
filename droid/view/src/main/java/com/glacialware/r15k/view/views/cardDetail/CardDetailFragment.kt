package com.glacialware.r15k.view.views.cardDetail

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.databinding.FragmentEditCardBinding
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import com.glacialware.r15k.view.wireframes.editCard.EditCardFragmentWireframe
import com.glacialware.r15k.viewmodel.views.cardDetail.CardDetailViewModel
import javax.inject.Inject

/**
* Created by Guille on 10/07/2017.
*/
class CardDetailFragment : GenericRootFragment<CardDetailViewModel, FragmentEditCardBinding>() {

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

    // ---- Dagger attributes ----
    @field:[Inject]
    protected lateinit var mWireframe: EditCardFragmentWireframe
    // ---- END Dagger attributes ----

    // ---- GenericRootFragment ----

    override fun initDI() {
        mFragmentComponent.inject(this)
    }

    override fun initViewModel() {
        if (activity != null) {
            mViewModel = ViewModelProviders.of(activity!!).get(CardDetailViewModel::class.java)
        }
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?): View? {
        mBinding = FragmentEditCardBinding.inflate(inflater, container, false)
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