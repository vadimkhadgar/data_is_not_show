package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.CountryListAdapter
import com.example.myapplication.data.network.CountriesApi
import com.example.myapplication.data.network.CountriesRepository
import com.example.myapplication.model.Country
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var factory: CountriesViewModelFactory
    private lateinit var vm: CountriesViewModel

    private var countriesList = arrayListOf<Country>()
    //  private lateinit var adapter: CountryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = CountriesApi()
        val repository =
            CountriesRepository(
                api
            )

        factory =
            CountriesViewModelFactory(
                repository
            )
        vm = ViewModelProvider(this, factory).get(CountriesViewModel::class.java)
        vm.getCountries()


//
//        vm.countries.observe(this, Observer { countries ->
//            Log.d("tutututu", countries.size.toString())
//            for (country in countries) {
//                countriesList.add(country)
//            }
//        })


        // Show recyclerView
        recyclerView.also { recyclerView ->
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.setHasFixedSize(true)
            //recyclerView.adapter = CountryListAdapter(countriesList)

            vm.countries.observe(this, Observer {
                recyclerView.adapter = CountryListAdapter(it)
            })

            //adapter.setUsers(countriesList)
            //it.addOnItemTouchListener(RecyclerItemClickListener(this, it, this))


            progressBar.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }
    }

    private fun showList() {
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }
}
