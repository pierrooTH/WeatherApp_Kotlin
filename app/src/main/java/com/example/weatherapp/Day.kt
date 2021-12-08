package com.example.weatherapp

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Day : Serializable {
    @SerializedName("avgtemp_c")
    var temp : Float = 0.0F

    @SerializedName("condition")
    var condition : Condition = Condition()
}