package com.glacialware.r15k.view.wireframes.generic

import android.databinding.ViewDataBinding
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import com.glacialware.r15k.viewmodel.views.generic.GenericViewModel

/**
 * Created by gcuestab on 2/3/18.
 */
abstract class GenericFragmentWireframe(protected val mFragment: GenericRootFragment<GenericFragmentWireframe, GenericViewModel, ViewDataBinding>)