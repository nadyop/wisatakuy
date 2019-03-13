package com.gdn.wisatakuy.ui.splashscreen

import com.gdn.wisatakuy.ui.base.BaseContract

class SplashScreenContract {

  interface View : BaseContract.View {
    fun goToActivity(role: String, userId: String)
  }

  interface Presenter : BaseContract.Presenter {
    fun attachView(view: View)
    fun loadUserInfo()
  }
}