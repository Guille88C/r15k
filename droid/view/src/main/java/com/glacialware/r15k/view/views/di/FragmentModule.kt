package com.glacialware.r15k.view.views.di

import android.content.Context
import android.support.v4.app.Fragment
import com.glacialware.r15k.view.scopes.PerFragment
import com.glacialware.r15k.view.components.CustomToast
import com.glacialware.r15k.view.wireframes.addPlayer.AddPlayerFragmentWireframe
import com.glacialware.r15k.view.wireframes.editCard.EditCardFragmentWireframe
import com.glacialware.r15k.view.wireframes.main.PlayersFragmentWireframe
import com.glacialware.r15k.view.wireframes.playerDetail.PlayerDetailFragmentWireframe
import dagger.Module
import dagger.Provides

/**
 * Created by gcuestab on 28/2/18.
 */
@Module
class FragmentModule(private val mFragment: Fragment) {
    @PerFragment
    @Provides
    fun provideCustomToastInstance() : CustomToast = CustomToast(mFragment.context)

    @PerFragment
    @Provides
    fun provideAddPlayerWireframe() = AddPlayerFragmentWireframe(mFragment)

    @PerFragment
    @Provides
    fun provideEditCardWireframe() = EditCardFragmentWireframe(mFragment)

    @PerFragment
    @Provides
    fun providePlayersWireframe() = PlayersFragmentWireframe(mFragment)

    @PerFragment
    @Provides
    fun providePlayerDetailWireframe() = PlayerDetailFragmentWireframe(mFragment)
}