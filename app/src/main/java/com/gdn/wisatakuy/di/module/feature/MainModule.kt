package com.gdn.wisatakuy.di.module.feature

import com.gdn.wisatakuy.ui.main.MainPresenter
import com.gdn.wisatakuy.di.scope.ActivityScope
import com.gdn.wisatakuy.ui.main.MainActivity
import com.gdn.wisatakuy.ui.main.MainContract
import dagger.Binds
import dagger.Module

@Module abstract class MainModule {

  @ActivityScope
  @Binds
  internal abstract fun provideMainView(mainView: MainActivity): MainContract.View

  @ActivityScope
  @Binds
  internal abstract fun provideMainPresenter(
      mainPresenter: MainPresenter): MainContract.Presenter
}