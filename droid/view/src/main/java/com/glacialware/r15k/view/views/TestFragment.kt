package com.glacialware.r15k.view.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.generic.GenericRootFragment

/**
* Created by Guille on 10/07/2017.
*/
class TestFragment : GenericRootFragment() {

    // ---- Companion ----

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

    // ---- END Companion ----

    // ---- Fragment ----

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun initPresenter() {

    }

    // ---- END Fragment ----

}