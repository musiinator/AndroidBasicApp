package com.example.test2

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class RetrofitSerialized {
    val contentType = "application/json".toMediaType()
    val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        coerceInputValues = true
    }
    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.dropbox.com/sh/1rbhhdzj2hz04i2/")
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()
}