package com.gdn.wisatakuy.ui.main

import com.gdn.wisatakuy.api.ApiInterface
import com.gdn.wisatakuy.ui.base.BasePresenter
import com.gdn.wisatakuy.util.LoginRepository
import javax.inject.Inject

class MainPresenter @Inject constructor(private val api: ApiInterface,
    private val loginRepository: LoginRepository) : BasePresenter(),
    MainContract.Presenter {

  private var view: MainContract.View? = null
  override fun attachView(view: MainContract.View) {
    this.view = view
  }
}