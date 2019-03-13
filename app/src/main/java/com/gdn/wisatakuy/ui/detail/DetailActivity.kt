package com.gdn.wisatakuy.ui.detail

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.gdn.wisatakuy.R
import com.gdn.wisatakuy.ui.base.BaseActivity
import com.gdn.wisatakuy.ui.dashboard.model.TourDetailUiModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.android.AndroidInjection
import java.io.IOException

class DetailActivity : BaseActivity(), DetailContract.View, OnMapReadyCallback {

  companion object {
    private const val DATA = "detail"
    private const val TAG = "detailActivity"

    fun newInstance(context: Context, detail: TourDetailUiModel): Intent {
      val intent = Intent(context, DetailActivity::class.java)
      intent.putExtra(
          DATA, detail) //from @Parcelize
      return intent
    }
  }

  private lateinit var binding: com.gdn.wisatakuy.databinding.ActivityDashboardDetailBinding
  private lateinit var detail: TourDetailUiModel
  private var googleMap: GoogleMap? = null
  private var lat: String = ""
  private var long: String = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard_detail)
    detail = intent.getParcelableExtra(DATA)
//    location(detail.nama_pariwisata)
    setData()
    userAction()

    val mapFragment = supportFragmentManager.findFragmentById(R.id.f_map) as SupportMapFragment
    mapFragment.getMapAsync(this)
  }

  private fun userAction() {
    binding.toolbar.setNavigationOnClickListener {
      onBackPressed()
    }
  }

  override fun setData() {

    Glide.with(this).load(detail.gambar_pariwisata).fitCenter().into(binding.ivGambar)
    with(binding) {
      tvNama.text = detail.nama_pariwisata
      tvDeskripsi.text = detail.detail_pariwisata
      tvAlamat.text = detail.alamat_pariwisata
//      tvAlamat.text = lat
    }
  }

  override fun showProgress(show: Boolean) {
    if (show) {
      binding.container.visibility = View.GONE
    } else {
      binding.container.visibility = View.VISIBLE
    }
  }

  fun location(address: String) {
    var addressList: List<Address> = listOf()
    val geoCoder = Geocoder(this)
    try {
      addressList = geoCoder.getFromLocationName("Candi Prambanan", 1)
    } catch (e: IOException) {
      e.printStackTrace()
    }
    Log.d("Test addressList", addressList.toString())
    if (addressList.isNotEmpty()) {
      val addressLoc = addressList[0]
      val latLng = LatLng(addressLoc.latitude, addressLoc.longitude)
      this.lat = addressLoc.latitude.toString()
      this.long = addressLoc.longitude.toString()
    }
  }

  override fun onMapReady(googleMap: GoogleMap?) {
    this.googleMap = googleMap

    val location = LatLng(23.777176, 90.399452)

    googleMap?.let {
      it.addMarker(
          location?.let { it1 -> MarkerOptions().position(it1).title(detail.nama_pariwisata) })
      it.moveCamera(CameraUpdateFactory.newLatLng(location))
    }
  }
}