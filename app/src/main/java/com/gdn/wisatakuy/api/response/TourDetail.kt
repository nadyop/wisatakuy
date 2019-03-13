package com.gdn.wisatakuy.api.response

import com.google.gson.annotations.SerializedName

data class TourDetail(

    @field:SerializedName("nama_pariwisata") val nama_pariwisata: String? = null,

    @field:SerializedName("alamat_pariwisata") val alamat_pariwisata: String? = null,

    @field:SerializedName("detail_pariwisata") val detail_pariwisata: String? = null,

    @field:SerializedName("gambar_pariwisata") val gambar_pariwisata: String? = null

)