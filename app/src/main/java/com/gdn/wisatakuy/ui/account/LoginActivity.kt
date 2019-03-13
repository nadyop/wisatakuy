package com.gdn.wisatakuy.ui.account

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.gdn.wisatakuy.R
import com.gdn.wisatakuy.databinding.ActivityLoginBinding
import com.gdn.wisatakuy.ui.base.BaseActivity
import com.gdn.wisatakuy.ui.main.MainActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : BaseActivity() {

  private lateinit var binding: ActivityLoginBinding
  private lateinit var auth: FirebaseAuth

  override fun onCreate(savedInstanceState: Bundle?) {
    FirebaseApp.initializeApp(this)
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

    //Initialize Firebase
    auth = FirebaseAuth.getInstance()

    if (auth.currentUser != null) {
      startActivity(Intent(this@LoginActivity, MainActivity::class.java))
      finish()
    }

    binding.btLogin.setOnClickListener {
      if (TextUtils.isEmpty(binding.etEmail.text.toString())) {
        Toast.makeText(applicationContext, "Masukkan email!", Toast.LENGTH_SHORT).show()
      } else if (TextUtils.isEmpty(binding.etPassword.text.toString())) {
        Toast.makeText(applicationContext, "Masukkan password!", Toast.LENGTH_SHORT).show()
      } else if(TextUtils.isEmpty(binding.etPassword.text.toString()) && TextUtils.isEmpty(binding.etEmail.text.toString())) {
        Toast.makeText(applicationContext, "Harap masukkan data!", Toast.LENGTH_SHORT).show()
      }

      auth.signInWithEmailAndPassword(binding.etEmail.text.toString(),
          binding.etPassword.text.toString()).addOnCompleteListener(this@LoginActivity) { task ->
        binding.progressBar.visibility = View.GONE
        if (!task.isSuccessful) {
          Toast.makeText(this@LoginActivity, getString(R.string.login_failed),
              Toast.LENGTH_LONG).show()
        } else {
          val intent = Intent(this@LoginActivity, MainActivity::class.java)
          startActivity(intent)
          finish()
        }
      }
    }

    binding.tvRegister.setOnClickListener {
      startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
    }
  }

  override fun onBackPressed() {
    super.onBackPressed()
    finish()
  }

  override fun showProgress(show: Boolean) {
    //do nothing
  }
}