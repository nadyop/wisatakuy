package com.gdn.wisatakuy.ui.splashscreen

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.gdn.wisatakuy.R
import com.gdn.wisatakuy.databinding.ActivitySplashscreenBinding
import com.gdn.wisatakuy.ui.base.BaseActivity
import com.gdn.wisatakuy.util.Router

class SplashScreenActivity : BaseActivity(), SplashScreenContract.View {

  private lateinit var binding: ActivitySplashscreenBinding
  val SPLASH_TIMEOUT: Long = 3000
  private var role = ""
  private var userId = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_splashscreen)

    if (userId != ""){
      goToActivity(role, userId)
    } else {
      Handler().postDelayed({
        Router.goToLogin(this)
      }, SPLASH_TIMEOUT)
    }
  }

  override fun goToActivity(role: String, userId: String) {
    this.role = role
    this.userId = userId

    Handler().postDelayed({
      Router.goToMain(this)
    }, SPLASH_TIMEOUT)
  }

  override fun showProgress(show: Boolean) {
    if (show) {
      binding.progressBar.visibility = View.VISIBLE
    } else {
      binding.progressBar.visibility = View.GONE
    }
  }
}