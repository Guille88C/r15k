package com.r15k.glacialware.r15k.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.r15k.glacialware.r15k.R
import com.r15k.glacialware.r15k.views.generic.GenericRootFragment

/**
 * Created by Guille on 10/07/2017.
 */
class TestFragment : GenericRootFragment() {
    companion object {
        @JvmStatic
        val TAG : String = this :: class.java.canonicalName

        @JvmStatic
        fun newInstance() : TestFragment {
            val f = TestFragment()
            val args = Bundle()
            f.arguments = args
            return f
        }
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun init() {

    }
}