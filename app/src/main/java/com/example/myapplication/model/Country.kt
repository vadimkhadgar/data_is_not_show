package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class Country(
    //val alpha2Code: String,
    //val alpha3Code: String,
    //val altSpellings: List<String>,
    @SerializedName("area")
    val area: Double,
    //val borders: List<String>,
    //val callingCodes: List<String>,
    @SerializedName("capital")
    val capital: String,
    //val cioc: String,
    //val currencies: List<Currency>,
    //val demonym: String,
    @SerializedName("flag")
    val flag: String,
    //val gini: Double,
    //val languages: List<Language>,
    //val latlng: List<Double>,
    @SerializedName("name")
    val name: String,
    //val nativeName: String,
    //val numericCode: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("region")
    val region: String
    //val regionalBlocs: List<RegionalBloc>,
    //val subregion: String,
    //val timezones: List<String>,
    //val topLevelDomain: List<String>,
    //val translations: Translations
)