package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.databinding.ActivityForeCastBinding
import com.squareup.picasso.Picasso

class ForeCastActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForeCastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForeCastBinding.inflate(layoutInflater)
        val dataFromSecondActivity = intent.extras?.getSerializable("data") as Weather
        binding.thirdActivityTextView.text = "Prévisions à 3 jours"
        binding.thirdActivityCityNameText.text = dataFromSecondActivity.location.name
        binding.thirdActivityFirstTemp.text = dataFromSecondActivity.forecast.forcastDay?.get(0)?.day?.temp.toString()+"°C"
        binding.thirdActivitySecondTemp.text = dataFromSecondActivity.forecast.forcastDay?.get(1)?.day?.temp.toString()+"°C"
        binding.thirdActivityThirdTemp.text = dataFromSecondActivity.forecast.forcastDay?.get(2)?.day?.temp.toString()+"°C"
        binding.thirdActivityFirstDate.text = dataFromSecondActivity.forecast.forcastDay?.get(0)?.date
        binding.thirdActivitySecondDate.text = dataFromSecondActivity.forecast.forcastDay?.get(1)?.date
        binding.thirdActivityThirdDate.text = dataFromSecondActivity.forecast.forcastDay?.get(2)?.date

        val urlWeatherToday = "https:"+dataFromSecondActivity.forecast.forcastDay?.get(0)?.day?.condition?.icon
        val urlWeatherTomorrow = "https:"+dataFromSecondActivity.forecast.forcastDay?.get(1)?.day?.condition?.icon
        val urlWeatherAfterTomorrow = "https:"+dataFromSecondActivity.forecast.forcastDay?.get(2)?.day?.condition?.icon
        Picasso.get().load(urlWeatherToday).into(binding.thirdActivityFirstLogo)
        Picasso.get().load(urlWeatherTomorrow).into(binding.thirdActivitySecondLogo)
        Picasso.get().load(urlWeatherAfterTomorrow).into(binding.thirdActivityThirdLogo)

        setContentView(binding.root)
    }
}