package com.glacialware.r15k.view.presenters.di

import com.glacialware.r15k.scopes.PerFragmentPresenter
import com.glacialware.r15k.view.presenters.GenericFragmentPresenter
import dagger.Subcomponent

/**
 * Created by gcuestab on 28/2/18.
 */
@PerFragmentPresenter
@Subcomponent(modules = [(GenericFragmentPresenterModule::class)])
interface GenericFragmentPresenterComponent {
    fun inject(presenter: GenericFragmentPresenter)
}