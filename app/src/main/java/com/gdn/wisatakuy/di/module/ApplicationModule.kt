package com.gdn.wisatakuy.di.module

import android.app.Application
import com.gdn.wisatakuy.ApplicationBase
import com.gdn.wisatakuy.di.scope.PerApplication
import com.gdn.wisatakuy.util.LoginRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [WebServiceModule::class])
class ApplicationModule(private val appBase: ApplicationBase) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return appBase
    }

    @Provides
    internal fun provideLoginRepository(): LoginRepository {
       return LoginRepository(appBase)
    }
}