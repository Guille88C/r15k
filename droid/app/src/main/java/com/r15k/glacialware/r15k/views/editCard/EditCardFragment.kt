package com.r15k.glacialware.r15k.views.addPlayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.r15k.glacialware.r15k.R
import com.r15k.glacialware.r15k.views.generic.GenericRootFragment

/**
 * Created by Guille on 10/07/2017.
 */
class EditCardFragment : GenericRootFragment() {
    companion object {
        @JvmStatic
        val TAG : String = this :: class.java.canonicalName

        @JvmStatic
        fun newInstance() : EditCardFragment {
            val f = EditCardFragment()
            val args = Bundle()
            f.arguments = args
            return f
        }
    }




    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_edit_card, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}