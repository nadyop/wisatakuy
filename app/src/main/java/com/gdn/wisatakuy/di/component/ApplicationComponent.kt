package com.gdn.wisatakuy.di.component

import com.gdn.wisatakuy.ApplicationBase
import com.gdn.wisatakuy.api.ApiInterface
import com.gdn.wisatakuy.di.module.ActivityModule
import com.gdn.wisatakuy.di.module.ApplicationModule
import com.gdn.wisatakuy.di.scope.ApplicationScope
import com.gdn.wisatakuy.util.LoginRepository
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@ApplicationScope
@Component(modules = [AndroidInjectionModule::class, ApplicationModule::class, ActivityModule::class])
interface ApplicationComponent : AndroidInjector<ApplicationBase>{

    fun apiInterface(): ApiInterface
    fun loginRepository(): LoginRepository
}