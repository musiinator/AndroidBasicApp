package com.example.test2
import Gallery
import retrofit2.http.GET

interface ApiService {
    @GET("AADZIm00bl9g13rNMe7E5CDga/images.json?dl=1")
    suspend fun getImages(): List<Gallery>
}
