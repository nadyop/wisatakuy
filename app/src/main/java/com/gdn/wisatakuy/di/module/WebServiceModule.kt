package com.gdn.wisatakuy.di.module

import com.gdn.wisatakuy.api.ApiInterface
import com.gdn.wisatakuy.util.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class WebServiceModule {

  private fun buildRetrofit(): Retrofit {

    val logging = HttpLoggingInterceptor()
    // set your desired log level
    logging.level = HttpLoggingInterceptor.Level.BODY
    val httpClient = OkHttpClient.Builder()
    // add logging as last interceptor
    httpClient.addInterceptor(logging)

    return retrofit2.Retrofit.Builder()
        .client(httpClient.build())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()
  }

  @Provides
  internal fun provideRetrofit(): Retrofit {
    return buildRetrofit()
  }

  @Provides
  internal fun provideApiInterface(retrofit: Retrofit): ApiInterface {
    return retrofit.create(ApiInterface::class.java)
  }
}