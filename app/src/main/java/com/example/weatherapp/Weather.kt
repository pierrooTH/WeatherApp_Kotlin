package com.example.weatherapp

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Weather : Serializable {
    @SerializedName("location")
    var location: Location = Location()

    @SerializedName("current")
    var current: Current = Current()

    @SerializedName("forecast")
    var forecast: Forecast = Forecast()
}