package com.gdn.wisatakuy.util

import android.content.Context
import android.content.SharedPreferences

class LoginRepository (context: Context){

  private val sharedPreferences: SharedPreferences

  var userId: String
    get() = sharedPreferences.getString(LoginRepository.USER_ID, "")
    set(userId) = sharedPreferences.edit().putString(LoginRepository.USER_ID, userId).apply()

  var role: String?
    get() = sharedPreferences.getString(LoginRepository.ROLE, "")
    set(role) = sharedPreferences.edit().putString(LoginRepository.ROLE, role).apply()

  init {
    this.sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
  }

  companion object {
    const val PREFS_NAME = "Login"
    const val USER_ID = "userId"
    const val ROLE = "role"
  }
}
