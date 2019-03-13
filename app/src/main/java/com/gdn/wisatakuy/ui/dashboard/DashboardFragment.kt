package com.gdn.wisatakuy.ui.dashboard

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gdn.wisatakuy.R
import com.gdn.wisatakuy.databinding.FragmentDashboardBinding
import com.gdn.wisatakuy.ui.base.BaseFragment
import com.gdn.wisatakuy.ui.dashboard.model.TourDetailUiModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_dashboard.*
import javax.inject.Inject

class DashboardFragment : BaseFragment() , DashboardContract.View {

  @Inject
  lateinit var presenter: DashboardContract.Presenter
  private lateinit var binding: FragmentDashboardBinding
  private var listAdapter: DashboardAdapter? = null

  override fun onCreate(savedInstanceState: Bundle?) {

    AndroidSupportInjection.inject(this)
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    presenter.attachView(this)
    initView()
  }

  private fun initView() {
    val layoutManager = GridLayoutManager(context, 2)
    binding.recyclerView.layoutManager = layoutManager

    if (listAdapter == null) {
      listAdapter = DashboardAdapter(ArrayList())
    }
    binding.recyclerView.adapter = listAdapter

    presenter.fetchData()
  }

  override fun fetchDataSuccess(list: MutableList<TourDetailUiModel>) {
    listAdapter?.addItems(list)
    recyclerView.adapter = listAdapter
  }

  override fun showProgress(show: Boolean) {
    if (show) {
      binding.progressBar.visibility = View.VISIBLE
    } else {
      binding.progressBar.visibility = View.GONE
    }
  }

  override fun showErrorMessage(error: String) {
    binding.tvNoData.visibility = View.VISIBLE
  }

  override fun showNoData() {
    binding.tvNoData.visibility = View.VISIBLE
  }

}