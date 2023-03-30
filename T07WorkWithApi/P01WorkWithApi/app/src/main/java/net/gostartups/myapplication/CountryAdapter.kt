package net.gostartups.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import net.gostartups.myapplication.databinding.CountryItemBinding
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountryAdapter(private val countries: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(val binding: CountryItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CountryItemBinding.inflate(layoutInflater, parent, false)

        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val currentCountry = countries[position]
        holder.binding.apply {
            country = currentCountry.name
            capital = currentCountry.capital

            Glide
                .with(this.root.context)
                .load(currentCountry.flags.png)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(ivFlag)
        }

        holder.binding.root.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://restcountries.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient())
                .build()

            val countryService = retrofit.create(CountryService::class.java)
            val countryRepository = CountriesRepository(countryService)

            countryRepository.getCountryByName(currentCountry.name)
                ?.enqueue(object : Callback<List<CountryDetailed>> {
                    override fun onResponse(
                        call: Call<List<CountryDetailed>>,
                        response: Response<List<CountryDetailed>>
                    ) {

                        val countryData = response.body() ?: return


                        val intent = Intent(holder.binding.root.context, SecondActivity::class.java)
                        intent.putExtra("name", countryData[0].name)
                        intent.putExtra("capital", countryData[0].capital)
                        intent.putExtra("flagUrl", countryData[0].flags.png)
                        intent.putExtra("region", countryData[0].region)
                        intent.putExtra("population", countryData[0].population.toString())
                        intent.putExtra("area", countryData[0].area.toString())
                        holder.binding.root.context.startActivity(intent)

                    }

                    override fun onFailure(call: Call<List<CountryDetailed>>, t: Throwable) {
                        Snackbar.make(it, "Failed to fetch countries", Snackbar.LENGTH_LONG)
                            .show()
                    }
                })
        }
    }

    override fun getItemCount() = countries.size
}