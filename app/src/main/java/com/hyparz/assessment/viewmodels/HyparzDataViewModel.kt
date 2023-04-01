package com.hyparz.assessment.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hyparz.assessment.HyparzApplication
import com.hyparz.assessment.model.HyparzRoot
import com.hyparz.assessment.repositories.HyparzDataRepoImpl
import com.hyparz.assessment.repositories.IHyparzDataRepo
import kotlinx.coroutines.launch

class HyparzDataViewModel : BaseViewModel() {

    private var allDataLiveData: MutableLiveData<List<Any>>? = null
    private lateinit var dataRepo: IHyparzDataRepo

    init {
        dataRepo = HyparzDataRepoImpl(this)
        allDataLiveData = MutableLiveData<List<Any>>()
    }

    fun getAllDataLiveData(): LiveData<List<Any>>? {
        return allDataLiveData
    }

    fun getAllData() {
        showProgress()
        viewModelScope.launch {
            dataRepo?.getAllData("100")
        }
    }

    override fun onResponse(isRemoteResponse: Boolean?, any: Any?) {
        hideProgress()
        Log.d("Amit ", "viewmodel success " + any)
        if (isRemoteResponse!!) {
            allDataLiveData?.value = (any as HyparzRoot).results
        }
    }

    override fun onFailure(error: Throwable?) {
        hideProgress()
        Toast.makeText(HyparzApplication.getAppContext(), "Opps Error Occured", Toast.LENGTH_LONG)
            .show()
    }
}