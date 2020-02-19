package com.example.myapplication.data.network

class CountriesRepository(
    private val api: CountriesApi
) : SafeApiRequest() {

    suspend fun getCountries() = apiRequest { api.getCountries() }
}