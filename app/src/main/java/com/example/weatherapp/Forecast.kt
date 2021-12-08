package com.example.weatherapp

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Forecast : Serializable {
    @SerializedName("forecastday")
    var forcastDay : Array<ForecastDay>? = null
}