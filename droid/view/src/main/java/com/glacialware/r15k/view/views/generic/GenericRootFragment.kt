package com.glacialware.r15k.view.views.generic

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.components.CustomToast
import com.glacialware.r15k.view.views.di.FragmentComponent
import com.glacialware.r15k.view.views.di.FragmentModule
import com.glacialware.r15k.viewmodel.views.generic.GenericViewModel
import javax.inject.Inject

/**
* Created by Guille on 09/07/2017.
*/
abstract class GenericRootFragment<T: GenericViewModel, Y: ViewDataBinding>: Fragment() {

    // ---- Dagger attributes ----

    @field:[Inject]
    protected lateinit var mToast: CustomToast

    // ---- END Dagger attributes ----

    // ---- Attributes ----

    protected lateinit var mBinding: Y
    protected lateinit var mViewModel: T
    protected lateinit var mFragmentComponent: FragmentComponent

    // ---- END Attributes ----

    // ---- Fragment ----

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initViewModel()
        return initView(inflater, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mFragmentComponent = (activity as GenericRootActivity<*>).mActivityComponent.with(FragmentModule(this))
        @Suppress("UNCHECKED_CAST")
        mFragmentComponent.inject(this as GenericRootFragment<GenericViewModel, ViewDataBinding>)

        initDI()
        initComponents()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        clear()
    }

    // ---- END Fragment ----

    // ---- Abstract ----

    abstract fun initDI()
    abstract fun initViewModel()
    abstract fun initView(inflater: LayoutInflater, container: ViewGroup?): View?
    abstract fun clear()
    abstract fun initComponents()

    // ---- END Abstract ----
}