package com.example.myapplication.adapter

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Country
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import kotlinx.android.synthetic.main.rv_item.view.*


class CountryListAdapter(private var countries: List<Country>) :
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

//    fun updateCountries(newCountries: ArrayList<Country>) {
//        countries.clear()
//        countries.addAll(newCountries)
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item, parent, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    // Country object for clickItemListener
    fun getCountryAtPosition(position: Int): Country {
        return countries[position]
    }

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val rv_country_item_layout = view.rv_item_layout
        private val flag = view.iv_flag
        private val countryName = view.tv_country_name
        private val capitalName = view.tv_country_capital_name

        fun bind(item: Country) {
            countryName?.text = item.name
            capitalName?.text = item.capital
            Log.d("imageimage", item.flag)
//            Glide.with(itemView)
//                .load(item.flag)
//                .into(iv_flag)
            GlideToVectorYou
                .init()
                .with(itemView.context)
                .setPlaceHolder(R.drawable.ic_error_black_24dp, R.drawable.ic_error_black_24dp)
                .load(Uri.parse(item.flag), flag)
        }
    }
}
