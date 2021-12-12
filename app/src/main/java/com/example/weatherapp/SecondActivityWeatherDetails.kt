package com.example.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.weatherapp.databinding.ActivitySecondWeatherDetailsBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondActivityWeatherDetails : AppCompatActivity() {

    private lateinit var binding: ActivitySecondWeatherDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondWeatherDetailsBinding.inflate(layoutInflater)
        val dataFromMainActivity = intent?.extras?.getSerializable("data") as Weather
        binding.secondActivityTextView.text = dataFromMainActivity.location.name
        binding.secondActivityTemp.text = dataFromMainActivity.current.temp.toString()+"°C"
        binding.secondActivityDescription.text = dataFromMainActivity.current.condition.text
        binding.secondActivityTextHumidity.text = "Taux d'humidité: " + dataFromMainActivity.current.humidity.toString()+"%"
        binding.secondActivityTextFeelslike.text = "Température ressentie: " + dataFromMainActivity.current.feelslike.toString()+"°C"
        binding.secondActivityWind.text = "Il souffle un vent "+cardinalPoint()+" et sa vitesse est de " + dataFromMainActivity.current.wind_kph.toString()+" km/h"

        val urlCurrentWeather = "https:"+dataFromMainActivity.current.condition.icon
        Picasso.get().load(urlCurrentWeather).into(binding.secondActivityImageWeather)

        setContentView(binding.root)
    }

    fun cardinalPoint(): String {
        val dataFromMainActivity = intent?.extras?.getSerializable("data") as Weather
        var cardinalPoint = ""
        if (dataFromMainActivity.current.wind_dir == "N") cardinalPoint = "de Nord"
        if (dataFromMainActivity.current.wind_dir == "NNE") cardinalPoint = "de Nord-Nord-Est"
        if (dataFromMainActivity.current.wind_dir == "NE") cardinalPoint = "de Nord-Est"
        if (dataFromMainActivity.current.wind_dir == "ENE") cardinalPoint = "d'Est-Nord-Est"
        if (dataFromMainActivity.current.wind_dir == "E") cardinalPoint = "d'Est"
        if (dataFromMainActivity.current.wind_dir == "ESE") cardinalPoint = "d'Est-Sud-Est"
        if (dataFromMainActivity.current.wind_dir == "SE") cardinalPoint = "du Sud-Est"
        if (dataFromMainActivity.current.wind_dir == "SSE") cardinalPoint = "du Sud-Sud-Est"
        if (dataFromMainActivity.current.wind_dir == "S") cardinalPoint = "du Sud"
        if (dataFromMainActivity.current.wind_dir == "SSW") cardinalPoint = "du Sud-Sud-Ouest"
        if (dataFromMainActivity.current.wind_dir == "SW") cardinalPoint = "du Sud-Ouest"
        if (dataFromMainActivity.current.wind_dir == "WSW") cardinalPoint = "d'Ouest-Sud-Ouest"
        if (dataFromMainActivity.current.wind_dir == "W") cardinalPoint = "d'Ouest"
        if (dataFromMainActivity.current.wind_dir == "WNW") cardinalPoint = "d'Ouest-Nord-Ouest"
        if (dataFromMainActivity.current.wind_dir == "NW") cardinalPoint = "de Nord-Ouest"
        if (dataFromMainActivity.current.wind_dir == "NNW") cardinalPoint = "de Nord-Nord-Ouest"
        return cardinalPoint
    }

    fun navigateToForeCastPage(view: View) {
        val navigateToThirdPage = Intent(this, ForeCastActivity::class.java)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val dataFromMainActivity = intent?.extras?.getSerializable("data") as Weather
        val cityName = dataFromMainActivity.location.name
        Log.d("city", cityName)

        val webService = retrofit.create(WebServiceInterface::class.java)
        val callWebServiceWithKey = webService.getForeCastJson("2df24a9d6af0495d8f4123409210712", cityName, "3", "fr")

        callWebServiceWithKey.enqueue(object : Callback<Weather> {
            override fun onResponse(
                call: Call<Weather>,
                response: Response<Weather>
            ) {
                val data = response.body()
                navigateToThirdPage.putExtra("data", data)
                startActivity(navigateToThirdPage)
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.d("ERR", t.message!!)
            }
        })
    }
}