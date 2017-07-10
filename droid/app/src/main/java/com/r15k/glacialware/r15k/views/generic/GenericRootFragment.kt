package com.r15k.glacialware.r15k.views.generic

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Guille on 09/07/2017.
 */
abstract class GenericRootFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        if (inflater != null && container != null)
            return this.inflateView(inflater, container)

        return null
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.init()
    }

    abstract fun inflateView(inflater: LayoutInflater,container: ViewGroup) : View
    abstract fun init()
}