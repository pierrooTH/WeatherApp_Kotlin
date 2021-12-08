package com.example.weatherapp

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ForecastDay : Serializable {
    @SerializedName("date")
    var date : String = ""

    @SerializedName("day")
    var day : Day = Day()

}