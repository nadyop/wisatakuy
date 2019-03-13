package com.gdn.wisatakuy.ui.dashboard.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TourDetailUiModel(
        val nama_pariwisata: String = "",
        val alamat_pariwisata: String = "",
        val detail_pariwisata: String = "",
        var gambar_pariwisata: String = ""
) : Parcelable