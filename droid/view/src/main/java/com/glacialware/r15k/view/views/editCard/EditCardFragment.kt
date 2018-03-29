package com.glacialware.r15k.view.views.editCard

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.databinding.FragmentEditCardBinding
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import com.glacialware.r15k.view.wireframes.editCard.EditCardFragmentWireframe
import com.glacialware.r15k.viewmodel.views.editCard.EditCardViewModel

/**
* Created by Guille on 10/07/2017.
*/
class EditCardFragment : GenericRootFragment<EditCardFragmentWireframe, EditCardViewModel, FragmentEditCardBinding>() {

    // ---- Companion ----
    companion object {
        val TAG : String = this :: class.java.canonicalName

        fun newInstance() : EditCardFragment {
            val f = EditCardFragment()
            val args = Bundle()
            f.arguments = args
            return f
        }
    }

    // ---- END Companion ----

    // ---- GenericRootFragment ----

    override fun initWireframe() {
        mWireframe = EditCardFragmentWireframe(this)
    }

    override fun initViewModel() {
        if (activity != null) {
            mViewModel = ViewModelProviders.of(activity!!).get(EditCardViewModel::class.java)
        }
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?): View? {
        mBinding = FragmentEditCardBinding.inflate(inflater, container, false)
        if (mViewModel != null) {
            mBinding.viewModel = mViewModel
        }
        return mBinding.root
    }

    override fun clear() {
        mBinding.unbind()
    }

    override fun initComponents() {

    }

    // ---- END GenericRootFragment ----

}