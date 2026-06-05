package com.example.orangcantkikapps.data.api

import com.example.orangcantkikapps.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel

}
