package com.glacialware.r15k.view.views.di

import android.support.v7.app.AppCompatActivity
import com.glacialware.r15k.view.scopes.PerActivity
import com.glacialware.r15k.view.wireframes.addPlayer.AddPlayerActivityWireframe
import com.glacialware.r15k.view.wireframes.cards.CardsActivityWireframe
import com.glacialware.r15k.view.wireframes.cardDetail.CardDetailActivityWireframe
import com.glacialware.r15k.view.wireframes.main.MainActivityWireframe
import com.glacialware.r15k.view.wireframes.playerDetail.PlayerDetailActivityWireframe
import com.glacialware.r15k.view.wireframes.splash.SplashActivityWireframe
import dagger.Module
import dagger.Provides

/**
 * Created by gcuestab on 28/2/18.
 */
@Module
class ActivityModule(private val mActivity: AppCompatActivity) {
    @PerActivity
    @Provides
    fun provideAddPlayerWireframe() = AddPlayerActivityWireframe(mActivity)

    @PerActivity
    @Provides
    fun provideEditCardWireframe() = CardDetailActivityWireframe(mActivity)

    @PerActivity
    @Provides
    fun provideMainWireframe() = MainActivityWireframe(mActivity)

    @PerActivity
    @Provides
    fun providePlayerDetailWireframe() = PlayerDetailActivityWireframe(mActivity)

    @PerActivity
    @Provides
    fun provideSplashWireframe() = SplashActivityWireframe(mActivity)

    @PerActivity
    @Provides
    fun provideCardsWireframe() = CardsActivityWireframe(mActivity)
}