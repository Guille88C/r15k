package com.glacialware.r15k.view.views.generic

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.components.CustomToast
import com.glacialware.r15k.view.views.di.GenericFragmentComponent
import com.glacialware.r15k.view.views.di.GenericFragmentModule
import com.glacialware.r15k.view.wireframes.generic.GenericFragmentWireframe
import com.glacialware.r15k.viewmodel.views.generic.GenericViewModel
import javax.inject.Inject

/**
* Created by Guille on 09/07/2017.
*/
abstract class GenericRootFragment<T, Y, U>: Fragment() where T: GenericFragmentWireframe, Y: GenericViewModel, U: ViewDataBinding {

    // ---- Dagger attributes ----

    @field:[Inject]
    lateinit var mToast: CustomToast

    // ---- END Dagger attributes ----

    // ---- Attributes ----

    protected lateinit var mBinding: U
    protected lateinit var mWireframe: T
    protected var mViewModel: Y? = null
    private var mComponent: GenericFragmentComponent? = null

    // ---- END Attributes ----

    // ---- Fragment ----

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initViewModel()
        return initView(inflater, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDI()
        initWireframe()
        initComponents()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        clear()
    }

    // ---- END Fragment ----

    // ---- Private ----

    @Suppress("UNCHECKED_CAST")
    private fun initDI() {
        mComponent = (activity as? GenericRootActivity)?.mComponent?.with(GenericFragmentModule(context))
        mComponent?.inject(this as GenericRootFragment<GenericFragmentWireframe, GenericViewModel, ViewDataBinding>)
    }

    // ---- END Private ----

    // ---- Abstract ----

    abstract fun initWireframe()
    abstract fun initViewModel()
    abstract fun initView(inflater: LayoutInflater, container: ViewGroup?): View?
    abstract fun clear()
    abstract fun initComponents()

    // ---- END Abstract ----
}