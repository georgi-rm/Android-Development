package net.gostartups.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryService {
    @GET("all")
    fun getCountries(): Call<List<Country>>

    @GET("name/{countryName}")
    fun getCountryByName(@Path("countryName") countryName: String): Call<List<CountryDetailed>>
}