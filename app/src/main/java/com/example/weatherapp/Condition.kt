package com.example.weatherapp

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Condition : Serializable {
    @SerializedName("text")
    var text : String = ""

    @SerializedName("icon")
    var icon : String = ""
}