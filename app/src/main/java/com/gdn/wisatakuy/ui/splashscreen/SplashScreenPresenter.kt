package com.gdn.wisatakuy.ui.splashscreen

import com.gdn.wisatakuy.ui.base.BasePresenter
import com.gdn.wisatakuy.util.LoginRepository
import javax.inject.Inject

class SplashScreenPresenter @Inject constructor(loginRepository: LoginRepository)
  : BasePresenter(), SplashScreenContract.Presenter{

  private lateinit var view: SplashScreenContract.View
  private val role = loginRepository.role
  private val userId = loginRepository.userId

  override fun attachView(view: SplashScreenContract.View) {
    this.view = view
  }

  override fun loadUserInfo() {
    role?.let {
      view.goToActivity(role, userId.toString())
    }
  }

}