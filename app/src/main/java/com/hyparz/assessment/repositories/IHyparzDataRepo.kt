package com.hyparz.assessment.repositories

interface IHyparzDataRepo {
    suspend fun getAllData(query:String?)
}