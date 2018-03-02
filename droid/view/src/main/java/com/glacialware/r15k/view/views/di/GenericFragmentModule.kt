package com.glacialware.r15k.view.views.di

import android.content.Context
import com.glacialware.r15k.scopes.PerFragmentPresenter
import com.glacialware.r15k.view.components.CustomToast
import dagger.Module
import dagger.Provides

/**
 * Created by gcuestab on 28/2/18.
 */
@Module
class GenericFragmentModule(private val mContext: Context?) {
    @Provides
    @PerFragmentPresenter
    fun provideCustomToastInstance() : CustomToast = CustomToast(mContext)
}