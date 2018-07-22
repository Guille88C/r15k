package com.glacialware.r15k.view.views.di

import android.support.v7.app.AppCompatActivity
import com.glacialware.r15k.view.wireframes.addPlayer.AddPlayerActivityWireframe
import com.glacialware.r15k.view.wireframes.cardDetail.CardDetailActivityWireframe
import com.glacialware.r15k.view.wireframes.cards.CardsActivityWireframe
import com.glacialware.r15k.view.wireframes.main.MainActivityWireframe
import com.glacialware.r15k.view.wireframes.playerDetail.PlayerDetailActivityWireframe
import com.glacialware.r15k.view.wireframes.splash.SplashActivityWireframe

object ActivityDependency {
    fun provideAddPlayerWireframe(activity: AppCompatActivity) = AddPlayerActivityWireframe(activity)
    fun provideEditCardWireframe(activity: AppCompatActivity) = CardDetailActivityWireframe(activity)
    fun provideMainWireframe(activity: AppCompatActivity) = MainActivityWireframe(activity)
    fun providePlayerDetailWireframe(activity: AppCompatActivity) = PlayerDetailActivityWireframe(activity)
    fun provideSplashWireframe(activity: AppCompatActivity) = SplashActivityWireframe(activity)
    fun provideCardsWireframe(activity: AppCompatActivity) = CardsActivityWireframe(activity)
}