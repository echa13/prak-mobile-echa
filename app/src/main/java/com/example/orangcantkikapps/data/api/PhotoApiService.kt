package com.example.orangcantkikapps.data.api

import com.example.orangcantkikapps.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}