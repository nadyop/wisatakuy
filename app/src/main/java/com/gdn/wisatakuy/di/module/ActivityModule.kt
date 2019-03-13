package com.gdn.wisatakuy.di.module

import com.gdn.wisatakuy.di.module.feature.DashboardModule
import com.gdn.wisatakuy.di.module.feature.DetailModule
import com.gdn.wisatakuy.di.module.feature.MainModule
import com.gdn.wisatakuy.di.scope.ActivityScope
import com.gdn.wisatakuy.ui.dashboard.DashboardFragment
import com.gdn.wisatakuy.ui.detail.DetailActivity
import com.gdn.wisatakuy.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [DashboardModule::class])
    abstract fun provideDashboardFragment(): DashboardFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun provideMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [DetailModule::class])
    abstract fun provideDetailActivity(): DetailActivity
}