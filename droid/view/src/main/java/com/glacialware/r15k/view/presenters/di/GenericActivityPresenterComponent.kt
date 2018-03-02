package com.glacialware.r15k.view.presenters.di

import com.glacialware.r15k.scopes.PerActivityPresenter
import dagger.Subcomponent

/**
 * Created by gcuestab on 28/2/18.
 */
@PerActivityPresenter
@Subcomponent(modules = ([GenericActivityPresenterModule::class]))
interface GenericActivityPresenterComponent {
}