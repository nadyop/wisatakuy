package com.gdn.wisatakuy.ui.account

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.gdn.wisatakuy.R
import com.gdn.wisatakuy.databinding.ActivityRegisterBinding
import com.gdn.wisatakuy.ui.base.BaseActivity
import com.gdn.wisatakuy.ui.main.MainActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : BaseActivity() {

  private lateinit var binding: ActivityRegisterBinding
  private lateinit var auth: FirebaseAuth

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

    // Init Firebase instance
    auth = FirebaseAuth.getInstance()

    binding.tvLogin.setOnClickListener {
      finish()
    }

    binding.btRegister.setOnClickListener {
      if (TextUtils.isEmpty(binding.etEmail.text.toString())) {
        Toast.makeText(applicationContext, "Masukkan email!", Toast.LENGTH_SHORT).show()
      } else if (TextUtils.isEmpty(binding.etPassword.text.toString())) {
        Toast.makeText(applicationContext, "Masukkan password!", Toast.LENGTH_SHORT).show()
      } else if (TextUtils.isEmpty(binding.etPassword.text.toString()) && TextUtils.isEmpty(binding.etEmail.text.toString())) {
        Toast.makeText(applicationContext, "Harap masukkan data!", Toast.LENGTH_SHORT).show()
      }
      binding.progressBar.visibility = View.VISIBLE
      auth.createUserWithEmailAndPassword(binding.etEmail.text.toString(),
          binding.etPassword.text.toString()).addOnCompleteListener(this@RegisterActivity) { task ->
        Toast.makeText(this@RegisterActivity, "Pendaftaran berhasil " + task.isSuccessful,
            Toast.LENGTH_SHORT).show()
        binding.progressBar.visibility = View.GONE

        if (!task.isSuccessful) {
          Toast.makeText(this@RegisterActivity, "Pendaftaran gagal" + task.exception!!,
              Toast.LENGTH_SHORT).show()
        } else {
          startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
          finish()
        }
      }
    }
  }

  override fun showProgress(show: Boolean) {
    //do nothing
  }
}