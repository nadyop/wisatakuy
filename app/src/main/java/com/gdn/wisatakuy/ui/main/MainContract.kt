package com.gdn.wisatakuy.ui.main

import android.support.v4.app.Fragment
import com.gdn.wisatakuy.ui.base.BaseContract

class MainContract {

  interface View: BaseContract.View {
    fun addFragment(fragment: Fragment)
  }

  interface Presenter: BaseContract.Presenter {
    fun attachView(view: View)
  }
}