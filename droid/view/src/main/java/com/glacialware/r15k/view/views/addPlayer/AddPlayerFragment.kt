package com.glacialware.r15k.view.views.addPlayer

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.databinding.FragmentAddPlayerBinding
import com.glacialware.r15k.view.presenters.addPlayer.AddPlayerFragmentPresenter
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import com.glacialware.r15k.view.wireframes.addPlayer.AddPlayerFragmentWireframe
import com.glacialware.r15k.viewmodel.interfaces.ICustomToast
import com.glacialware.r15k.viewmodel.views.addPlayer.AddPlayerViewModel

/**
* Created by Guille on 10/07/2017.
*/
class AddPlayerFragment : GenericRootFragment(), ICustomToast {

    // ---- Companion ----

    companion object {
        val TAG : String = this :: class.java.canonicalName

        fun newInstance() : AddPlayerFragment {
            val f = AddPlayerFragment()
            val args = Bundle()
            f.arguments = args
            return f
        }
    }

    // ---- End Companion ----

    // ---- GenericRootFragment ----

    override fun initPresenter() {
        mPresenter = AddPlayerFragmentPresenter()
    }

    override fun initWireframe() {
        mWireframe = AddPlayerFragmentWireframe(this)
    }

    override fun initViewModel() {
        if (activity != null) {
            mViewModel = ViewModelProviders.of(activity!!).get(AddPlayerViewModel::class.java)
        }
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?): View? {
        mBinding = FragmentAddPlayerBinding.inflate(inflater, container, false)
        (mBinding as FragmentAddPlayerBinding).viewModel = mViewModel as AddPlayerViewModel
        return mBinding.root
    }

    override fun clear() {
        mBinding.unbind()
    }

    override fun initComponents() {
        (mViewModel as AddPlayerViewModel).iToast = this
    }

    // ---- END GenericRootFragment ----

    // ---- ICustomToast ----

    override fun startToast(sText: String) {
        mToast.startToast(sText)
    }

    // ---- END ICustomToast ----
}