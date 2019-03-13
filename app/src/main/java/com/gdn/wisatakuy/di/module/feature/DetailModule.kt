package com.gdn.wisatakuy.di.module.feature

import com.gdn.wisatakuy.di.scope.ActivityScope
import com.gdn.wisatakuy.ui.detail.DetailActivity
import com.gdn.wisatakuy.ui.detail.DetailContract
import dagger.Binds
import dagger.Module

@Module
abstract class DetailModule {

  @ActivityScope
  @Binds
  abstract fun provideUserView(
      detailActivity: DetailActivity): DetailContract.View
}