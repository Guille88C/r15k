package com.glacialware.r15k.view.di

import com.glacialware.r15k.view.presenters.addPlayer.AddPlayerFragmentPresenter
import com.glacialware.r15k.view.views.addPlayer.AddPlayerFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Guille on 16/11/2017.
 */
@Singleton
@Component(
    modules = arrayOf(CustomToastModule::class)
)
interface CustomToastComponent {
    fun inject(addPlayer : AddPlayerFragmentPresenter)
}