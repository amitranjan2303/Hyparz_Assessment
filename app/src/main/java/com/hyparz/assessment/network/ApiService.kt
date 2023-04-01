package com.hyparz.assessment.network

import com.hyparz.assessment.model.HyparzRoot
import com.hyparz.assessment.utilities.AppUtility
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(AppUtility.BASE_PATH)
    fun getAllData(@Query("results") data: String?): Call<HyparzRoot>
}