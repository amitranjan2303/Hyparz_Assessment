package com.hyparz.assessment.callback

interface NetworkCallBack {
    fun onResponse(isRemoteResponse: Boolean?, any: Any?)
    fun onFailure(error: Throwable?)
}