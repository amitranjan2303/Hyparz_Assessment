package com.hyparz.assessment.repositories

import com.hyparz.assessment.HyparzApplication
import com.hyparz.assessment.model.HyparzRoot
import com.hyparz.assessment.network.AppRetrofitClient
import com.hyparz.assessment.utilities.AppUtility
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class BaseRepository<out S> {

    protected val TAG: String = BaseRepository::class.java.simpleName
    abstract fun onError(error: Throwable)
    abstract fun onSuccess(body: Any)
//    protected var appDb: MealAppDB
    protected val service: S

    constructor(clazz: Class<S>) {
        service = AppRetrofitClient.buildService(clazz)
//        appDb = MealAppDB.getDataBase(HyparzApplication.getAppContext()!!)
    }

    protected fun <T> enqueue(call: Call<T>) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                try {
                    val data = response.body()
                    if (response.isSuccessful) {
                        if (data != null) {
                            println("SUCCESS")
                            onSuccess(data)
                        }
                    } else {
                        // error response, no access to resource?
                        println("FAIL: Response Unsuccessful")
                        onError(java.lang.Exception("Opps! something went wrong"))
                    }
                } catch (e: java.lang.Exception) {
                    onError(e)
                }
            }

            override fun onFailure(call: Call<T>, error: Throwable) {
                // handle failure
                println("FAIL: Call Failed")
                println(error.message)
                onError(java.lang.Exception("Opps! something went wrong"))
            }
        })
    }

    protected fun onNetworkErrorCheck(){
        if (!AppUtility.isNetworkAvailable(HyparzApplication.getAppContext()!!)) {
            onError(Exception("Please check internet connection"))
            return
        }
    }
}