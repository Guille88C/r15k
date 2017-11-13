package com.glacialware.r15k.view.views.addPlayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.wireframes.navigateTo
import com.glacialware.r15k.view.views.TestFragment
import com.glacialware.r15k.view.views.generic.GenericRootFragment
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




    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_add_player, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAddPlayer()
    }




    fun initAddPlayer() {
        this.addPlayerB.setOnClickListener({
            navigateTo(this.activity.supportFragmentManager, TestFragment.newInstance(), TestFragment.TAG, R.id.activity_add_player_content_frame, false, true)
        })
    }
}