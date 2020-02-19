package com.example.myapplication.data.network

import com.example.myapplication.model.Country
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// https://restcountries.eu/rest/v2/all

const val BASE_URL = "https://restcountries.eu/rest/"

interface CountriesApi {

    @GET("v2/all/") //"countriesV2.json"
    suspend fun getCountries(): Response<List<Country>>

    companion object {
        operator fun invoke(
        ): CountriesApi {

            val okHttpClient = OkHttpClient.Builder()
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CountriesApi::class.java)
        }
    }
}