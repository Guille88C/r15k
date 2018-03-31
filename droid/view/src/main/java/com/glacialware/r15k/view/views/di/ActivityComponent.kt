package com.glacialware.r15k.view.views.di

import com.glacialware.r15k.view.scopes.PerActivity
import com.glacialware.r15k.view.views.addPlayer.AddPlayerActivity
import com.glacialware.r15k.view.views.cardDetail.CardDetailActivity
import com.glacialware.r15k.view.views.main.MainActivity
import com.glacialware.r15k.view.views.playerDetail.PlayerDetailActivity
import com.glacialware.r15k.view.views.splash.SplashActivity
import dagger.Subcomponent

/**
 * Created by gcuestab on 28/2/18.
 */
@PerActivity
@Subcomponent(modules = ([ActivityModule::class]))
interface ActivityComponent {
    fun inject(activity: AddPlayerActivity)
    fun inject(activity: CardDetailActivity)
    fun inject(activity: MainActivity)
    fun inject(activity: PlayerDetailActivity)
    fun inject(activity: SplashActivity)

    fun with(module: FragmentModule): FragmentComponent
}