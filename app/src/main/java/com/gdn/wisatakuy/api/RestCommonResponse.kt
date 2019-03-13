package com.gdn.wisatakuy.api

import com.google.gson.annotations.SerializedName

open class RestCommonResponse(

		@field:SerializedName("result") val result: String = "true"
)