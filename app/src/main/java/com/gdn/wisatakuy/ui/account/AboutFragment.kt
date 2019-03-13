package com.gdn.wisatakuy.ui.account

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gdn.wisatakuy.R
import com.gdn.wisatakuy.databinding.FragmentAboutBinding
import com.gdn.wisatakuy.ui.base.BaseFragment
import com.gdn.wisatakuy.util.Router
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class AboutFragment : BaseFragment() {

  private lateinit var binding: FragmentAboutBinding
  private lateinit var auth: FirebaseAuth

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    FirebaseApp.initializeApp(context)
    auth = FirebaseAuth.getInstance()
  }

  private fun logout() {
    auth.signOut()
    context?.let { Router.goToLogin(it) }
  }

  override fun onResume() {
    super.onResume()

    binding.btLogout.setOnClickListener {
      logout()
    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false)
    return binding.root
  }
}