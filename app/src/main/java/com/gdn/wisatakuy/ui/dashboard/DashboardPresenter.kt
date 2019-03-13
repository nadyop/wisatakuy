package com.gdn.wisatakuy.ui.dashboard

import android.util.Log
import com.gdn.wisatakuy.api.ApiInterface
import com.gdn.wisatakuy.api.RestListResponse
import com.gdn.wisatakuy.api.response.TourDetail
import com.gdn.wisatakuy.ui.base.BasePresenter
import com.gdn.wisatakuy.ui.dashboard.model.TourDetailUiModel
import com.gdn.wisatakuy.ui.dashboard.model.TourMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DashboardPresenter @Inject constructor(private val api: ApiInterface) :
    BasePresenter(), DashboardContract.Presenter {

  private lateinit var view: DashboardContract.View
  private val subscriptions = CompositeDisposable()

  override fun fetchData() {
    val subscribe = api.getTourList().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ list: RestListResponse<TourDetail> ->
          view.showProgress(false)
          Log.d("AAAAZ", "sukses nihh")
          val listItems: MutableList<TourDetailUiModel> = ArrayList()
          list.data.forEach { contentElement ->
            listItems.add(TourMapper.mapToTourDetailUiModel(contentElement))
          }
          view.fetchDataSuccess(listItems)
          if (list.data.isEmpty()) {
            view.showNoData()
          }

        }, { error ->
          view.showProgress(false)
          Log.d("AAAAZ", "error nihh data get+ ==== + ${error.message} + ==== + ${error.cause}")
          view.showErrorMessage(error.localizedMessage)
        })

    subscriptions.add(subscribe)
  }

  override fun attachView(view: DashboardContract.View) {
    this.view = view
  }
}