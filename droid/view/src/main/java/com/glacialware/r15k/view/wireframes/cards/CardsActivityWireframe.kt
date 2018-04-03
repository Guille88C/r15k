package com.glacialware.r15k.view.wireframes.cards

import android.support.v7.app.AppCompatActivity
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.cards.CardsFragment
import com.glacialware.r15k.view.wireframes.generic.GenericActivityWireframe
import com.glacialware.r15k.view.wireframes.navigateTo

/**
 * Created by gcuestab on 2/4/18.
 */
class CardsActivityWireframe(activity: AppCompatActivity): GenericActivityWireframe(activity) {
    // ---- GenericActivityWireframe ----
    override fun initFragment() {
        navigateTo(mActivity.supportFragmentManager, CardsFragment.newInstance(), CardsFragment.TAG, R.id.frame_content, true, false)
    }
    // ---- END GenericActivityWireframe ----
}