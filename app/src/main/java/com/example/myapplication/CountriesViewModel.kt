package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.network.CountriesRepository
import com.example.myapplication.model.Country
import com.example.myapplication.utils.Coroutines
import kotlinx.coroutines.Job


class CountriesViewModel(private val repository: CountriesRepository) : ViewModel() {

    private lateinit var job: Job

    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>>
        get() = _countries

    fun getCountries() {
        job = Coroutines.ioThenMain(
            { repository.getCountries() },
            { _countries.value = it }
        )
        Log.d("tutututut", countries.toString())
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) {
            job.cancel()
        }
    }
}