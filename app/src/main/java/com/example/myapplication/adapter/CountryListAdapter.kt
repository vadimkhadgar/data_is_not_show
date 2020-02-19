package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.model.Country
import kotlinx.android.synthetic.main.rv_item.view.*

//class CountryListAdapter(context: Context) :
//    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {
//
//    //    fun updateCountries(newCountries: ArrayList<Country>) {
////        countries.clear()
////        countries.addAll(newCountries)
////        notifyDataSetChanged()
////    }
//    private var countries = emptyList<Country>() // Cached copy of users
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.rv_item, parent, false)
//
//        return CountryViewHolder(view)
//    }
//
//
//    override fun getItemCount(): Int {
//        return countries.size
//    }
//
//    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
//        holder.bind(countries[position])
//    }
//
//    // Country object for clickItemListener
//    fun getCountryAtPosition(position: Int): Country {
//        return countries[position]
//    }
//
//    internal fun setUsers(countries: List<Country>) {
//        this.countries = countries
//        notifyDataSetChanged()
//    }
//
//    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        private val rv_country_item_layout = itemView.rv_item_layout
//        val iv_flag:ImageView = itemView.findViewById(R.id.iv_flag)
//        val tv_country_name: TextView = itemView.findViewById(R.id.tv_country_name)
//        private val tv_country_capital_name: TextView = itemView.findViewById(R.id.tv_country_capital_name)
//
//        fun bind(country: Country) {
//            tv_country_name.text = country.name
//            tv_country_capital_name.text = country.capital
//
//            Glide.with(itemView)
//                .load(country.flag)
//                .error(R.drawable.ic_error_black_24dp)
//                .into(iv_flag)
//        }
//    }
//}

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
        private val iv_flag = view.iv_flag
        private val tv_country_name = view.tv_country_name
        private val tv_country_capital_name = view.tv_country_capital_name

        fun bind(item: Country) {
            tv_country_name?.text = item.name
            tv_country_capital_name?.text = item.capital
            Glide.with(itemView)
                .load(item.flag)
                .into(iv_flag)
        }
    }
}
