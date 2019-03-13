package com.gdn.wisatakuy.di.module.feature

import com.gdn.wisatakuy.di.scope.ActivityScope
import com.gdn.wisatakuy.ui.dashboard.DashboardContract
import com.gdn.wisatakuy.ui.dashboard.DashboardFragment
import com.gdn.wisatakuy.ui.dashboard.DashboardPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class DashboardModule {

  @ActivityScope
  @Binds
  abstract fun provideUserView(
      dashboardFragment: DashboardFragment): DashboardContract.View

  @ActivityScope
  @Binds
  abstract fun provideUserPresenter(
      dashboardPresenter: DashboardPresenter): DashboardContract.Presenter
}