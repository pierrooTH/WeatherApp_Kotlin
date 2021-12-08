package com.example.weatherapp

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Location : Serializable {
    @SerializedName("name")
    var name : String = ""


}