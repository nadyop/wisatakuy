package com.gdn.wisatakuy.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.util.Log
import android.view.Menu
import com.gdn.wisatakuy.R
import com.gdn.wisatakuy.databinding.ActivityMainUserBinding
import com.gdn.wisatakuy.ui.account.AboutFragment
import com.gdn.wisatakuy.ui.base.BaseActivity
import com.gdn.wisatakuy.ui.dashboard.DashboardFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main_user.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View, HasSupportFragmentInjector {

  @Inject
  internal lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

  @Inject
  lateinit var presenter: MainContract.Presenter
  private var tabIndex = 0
  private lateinit var binding: ActivityMainUserBinding

  override fun supportFragmentInjector(): AndroidInjector<Fragment> {
    return supportFragmentInjector
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main_user)

    AndroidInjection.inject(this)

    presenter.attach()
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    val fragment = DashboardFragment()
    addFragment(fragment)
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_user, menu)
    return true
  }

  private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
    when (item.itemId) {
      R.id.navigation_home -> {
        inflateDashboardFragmentIntoMainActivity()
        return@OnNavigationItemSelectedListener true
      }
      R.id.navigation_account -> {
        inflateAboutFragmentIntoMainActivity()
        return@OnNavigationItemSelectedListener true
      }
    }
    false
  }

  private fun inflateDashboardFragmentIntoMainActivity() {
    val fragment = DashboardFragment()
    addFragment(fragment)
  }

  private fun inflateAboutFragmentIntoMainActivity() {
    val fragment = AboutFragment()
    addFragment(fragment)
  }

  override fun addFragment(fragment: Fragment) {
    val data = Bundle()
    data.putInt("DEFAULT_TAB", tabIndex)
    supportFragmentManager
        .beginTransaction()
        .disallowAddToBackStack()
        .replace(R.id.container_main, fragment, fragment.javaClass.simpleName)
        .commit()
  }

  override fun onBackPressed() {
    super.onBackPressed()

    finish()
  }

  override fun showProgress(show: Boolean) {
    Log.d(javaClass.simpleName, "showprogress")
  }
}