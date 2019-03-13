package com.gdn.wisatakuy.util

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.gdn.wisatakuy.ui.account.LoginActivity
import com.gdn.wisatakuy.ui.dashboard.model.TourDetailUiModel
import com.gdn.wisatakuy.ui.detail.DetailActivity
import com.gdn.wisatakuy.ui.main.MainActivity

interface Router {
  companion object {

    private val PARAM_MAIN_MENU = "mainMenu"

    fun goToMain(context: Context) {
      val intent = Intent(context, MainActivity::class.java)
      context.startActivity(intent)
    }

    fun goToLogin(context: Context) {
      val intent = Intent(context, LoginActivity::class.java)
      intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
      context.startActivity(intent)
    }
  }
}