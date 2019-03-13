package com.gdn.wisatakuy.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RestListResponse<T> (
    @field:SerializedName("data") @field:Expose var data: List<T>
): RestCommonResponse()