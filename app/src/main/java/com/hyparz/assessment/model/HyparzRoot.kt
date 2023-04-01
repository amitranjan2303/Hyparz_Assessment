package com.hyparz.assessment.model

import com.google.gson.annotations.SerializedName

data class HyparzRoot(
    @SerializedName("results") var results: ArrayList<Results> = arrayListOf(),
    @SerializedName("info") var info: Info? = Info()
)