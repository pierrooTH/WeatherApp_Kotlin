package com.example.weatherapp

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Current : Serializable {
    @SerializedName("temp_c")
    var temp : Float = 0.0F

    @SerializedName("wind_kph")
    var wind_kph : Float = 0.0F

    @SerializedName("wind_dir")
    var wind_dir : String = ""

    @SerializedName("humidity")
    var humidity : Int = 0

    @SerializedName("feelslike_c")
    var feelslike : Float = 0.0F

    @SerializedName("condition")
    var condition : Condition = Condition()
}