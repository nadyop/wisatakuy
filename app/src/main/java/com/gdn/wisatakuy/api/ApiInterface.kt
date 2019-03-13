package com.gdn.wisatakuy.api

import com.gdn.wisatakuy.api.response.TourDetail
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {

    //    jsonBootcamp.php
    @GET("jsonBootcamp.php")
    fun getTourList(): Observable<RestListResponse<TourDetail>>

}