package com.gdn.wisatakuy.ui.dashboard

import com.gdn.wisatakuy.ui.base.BaseContract
import com.gdn.wisatakuy.ui.dashboard.model.TourDetailUiModel

class DashboardContract {

  interface View: BaseContract.View {
    fun fetchDataSuccess(list: MutableList<TourDetailUiModel>)
    fun showNoData()
  }

  interface Presenter: BaseContract.Presenter {
    fun fetchData()
    fun attachView(view: View)
  }
}