package com.gdn.wisatakuy.ui.dashboard.model

import com.gdn.wisatakuy.api.response.TourDetail

interface TourMapper {
    companion object {
        fun mapToTourDetailUiModel(item: TourDetail): TourDetailUiModel {
            return TourDetailUiModel(
                    item.nama_pariwisata.orEmpty(),
                    item.alamat_pariwisata.orEmpty(),
                    item.detail_pariwisata.orEmpty(),
                    item.gambar_pariwisata.orEmpty()
            )
        }
    }
}