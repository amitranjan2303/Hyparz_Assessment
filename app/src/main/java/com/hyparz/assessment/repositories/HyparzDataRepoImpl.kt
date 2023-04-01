package com.hyparz.assessment.repositories

import android.util.Log
import com.hyparz.assessment.callback.NetworkCallBack
import com.hyparz.assessment.model.HyparzRoot
import com.hyparz.assessment.network.ApiService
import retrofit2.Call

class HyparzDataRepoImpl(val networkCallBack: NetworkCallBack?) :
    BaseRepository<ApiService>(ApiService::class.java), IHyparzDataRepo {

    override fun onSuccess(body: Any) {
        Log.d("Amit ","repo success "+body)
        networkCallBack?.onResponse(true, body)
    }

    override fun onError(error: Throwable) {
        Log.d("Amit ","repo error "+error)
        networkCallBack?.onFailure(error)
    }

    override suspend fun getAllData(query: String?) {
        onNetworkErrorCheck()
        var call: Call<HyparzRoot> = service.getAllData(query)
        enqueue(call)
    }
}