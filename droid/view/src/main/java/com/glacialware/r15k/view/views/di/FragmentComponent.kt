package com.glacialware.r15k.view.views.di

import android.databinding.ViewDataBinding
import com.glacialware.r15k.view.scopes.PerFragment
import com.glacialware.r15k.view.views.addPlayer.AddPlayerFragment
import com.glacialware.r15k.view.views.cardDetail.CardDetailFragment
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import com.glacialware.r15k.view.views.main.PlayersFragment
import com.glacialware.r15k.view.views.playerDetail.PlayerDetailFragment
import com.glacialware.r15k.viewmodel.views.generic.GenericViewModel
import dagger.Subcomponent

/**
 * Created by gcuestab on 28/2/18.
 */
@PerFragment
@Subcomponent(modules = [(FragmentModule::class)])
interface FragmentComponent {
    fun inject(fragment: GenericRootFragment<GenericViewModel, ViewDataBinding>)

    fun inject(fragment: AddPlayerFragment)
    fun inject(fragment: CardDetailFragment)
    fun inject(fragment: PlayersFragment)
    fun inject(fragment: PlayerDetailFragment)
}