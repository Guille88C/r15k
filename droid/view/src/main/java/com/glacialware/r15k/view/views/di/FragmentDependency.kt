package com.glacialware.r15k.view.views.di

import android.content.Context
import android.support.v4.app.Fragment
import com.glacialware.r15k.view.components.CustomToast
import com.glacialware.r15k.view.wireframes.addPlayer.AddPlayerFragmentWireframe
import com.glacialware.r15k.view.wireframes.cardDetail.CardDetailFragmentWireframe
import com.glacialware.r15k.view.wireframes.main.PlayersFragmentWireframe
import com.glacialware.r15k.view.wireframes.playerDetail.PlayerDetailFragmentWireframe

object FragmentDependency {
    fun provideCustomToastInstance(context: Context) = CustomToast(context)
    fun provideAddPlayerWireframe(fragment: Fragment) = AddPlayerFragmentWireframe(fragment)
    fun provideEditCardWireframe(fragment: Fragment) = CardDetailFragmentWireframe(fragment)
    fun providePlayersWireframe(fragment: Fragment) = PlayersFragmentWireframe(fragment)
    fun providePlayerDetailWireframe(fragment: Fragment) = PlayerDetailFragmentWireframe(fragment)
}