package com.glacialware.r15k.view.views.generic

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.presenters.GenericFragmentPresenter

/**
 * Created by Guille on 09/07/2017.
 */
abstract class GenericRootFragment: Fragment()  {
    protected var presenter: GenericFragmentPresenter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (presenter != null && inflater != null && container != null) {
            return presenter?.initViewModel(inflater, container)
        }

        return null
    }
}