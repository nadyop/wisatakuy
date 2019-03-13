package com.gdn.wisatakuy.ui.dashboard

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.gdn.wisatakuy.R
import com.gdn.wisatakuy.databinding.ItemSimpleGridBinding
import com.gdn.wisatakuy.ui.base.BaseRecyclerViewListAdapter
import com.gdn.wisatakuy.ui.dashboard.model.TourDetailUiModel
import com.gdn.wisatakuy.ui.detail.DetailActivity

class DashboardAdapter(
    tourDetailUiModels: MutableList<TourDetailUiModel>)
  : BaseRecyclerViewListAdapter<TourDetailUiModel, DashboardAdapter.ViewHolder>(tourDetailUiModels) {

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val itemGridBinding = DataBindingUtil.bind<ItemSimpleGridBinding>(itemView)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val itemView = LayoutInflater.from(parent.context).inflate(
        R.layout.item_simple_grid, parent, false
    )
    return ViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val product = getItem(position)

    holder.itemGridBinding?.apply {
      with(product) {
        Glide.with(ivProduct.context).load(gambar_pariwisata).placeholder(
            R.drawable.no_image_available
        ).into(ivProduct)
        cardView.setOnClickListener {
          val intent = DetailActivity.newInstance(it.context, this)
          val bundle = Bundle()
          bundle.putString("nama_pariwisata", nama_pariwisata)
          bundle.putString("alamat_pariwisata", alamat_pariwisata)
          bundle.putString("detail_pariwisata", detail_pariwisata)
          bundle.putString("gambar_pariwisata", gambar_pariwisata)
          intent.putExtras(bundle)
          it.context.startActivity(intent)
          Log.d("bundlenya", bundle.toString())
        }
        tvProductName.text = nama_pariwisata.capitalize()
        tvProductPriceDay.text = alamat_pariwisata
      }
    }
  }
}