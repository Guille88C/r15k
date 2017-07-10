package com.r15k.glacialware.r15k.views.addPlayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.r15k.glacialware.r15k.R
import com.r15k.glacialware.r15k.rooting.navigateTo
import com.r15k.glacialware.r15k.views.TestFragment
import com.r15k.glacialware.r15k.views.generic.GenericRootFragment
import kotlinx.android.synthetic.main.fragment_add_player.*

/**
 * Created by Guille on 10/07/2017.
 */
class AddPlayerFragment : GenericRootFragment() {
    companion object {
        @JvmStatic
        val TAG : String = this :: class.java.canonicalName

        @JvmStatic
        fun newInstance() : AddPlayerFragment {
            val f = AddPlayerFragment()
            val args = Bundle()
            f.arguments = args
            return f
        }
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.fragment_add_player, container, false)
    }

    override fun init() {
        this.addPlayerB.setOnClickListener({
            navigateTo(this.activity.supportFragmentManager, TestFragment.newInstance(), TestFragment.TAG, R.id.activity_add_player_content_frame, false, true)
        })
    }
}