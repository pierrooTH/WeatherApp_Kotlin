package com.example.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.weatherapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.mainActivityTextView.text = "Meteo App"

        setContentView(binding.root)
    }

    fun navigateToLilleButtonWeather(view: View) {
        val navigateToLilleBtnIntent = Intent(this, SecondActivityWeatherDetails::class.java)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val webService = retrofit.create(WebServiceInterface::class.java)
        val callWebServiceWithKey = webService.getJson("2df24a9d6af0495d8f4123409210712", "Lille", "fr")
        callWebServiceWithKey.enqueue(object : Callback<Weather>{
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                val data = response.body()
                navigateToLilleBtnIntent.putExtra("data", data)
                startActivity(navigateToLilleBtnIntent)
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.d("ERR", t.message!!)
            }

        })
    }
    fun navigateToArrasButtonWeather(view: View) {
        val navigateToArrasBtnIntent = Intent(this, SecondActivityWeatherDetails::class.java)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val webService = retrofit.create(WebServiceInterface::class.java)
        val callWebServiceWithKey = webService.getJson("2df24a9d6af0495d8f4123409210712", "Arras", "fr")
        callWebServiceWithKey.enqueue(object : Callback<Weather>{
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                val data = response.body()
                navigateToArrasBtnIntent.putExtra("data", data)
                startActivity(navigateToArrasBtnIntent)
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.d("ERR", t.message!!)
            }

        })
    }
    fun navigateToCambraiButtonWeather(view: View) {
        val navigateToCambraiBtnIntent = Intent(this, SecondActivityWeatherDetails::class.java)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val webService = retrofit.create(WebServiceInterface::class.java)
        val callWebServiceWithKey = webService.getJson("2df24a9d6af0495d8f4123409210712", "Cambrai", "fr")
        callWebServiceWithKey.enqueue(object : Callback<Weather>{
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                val data = response.body()
                navigateToCambraiBtnIntent.putExtra("data", data)
                startActivity(navigateToCambraiBtnIntent)
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.d("ERR", t.message!!)
            }

        })
    }
    fun navigateToDouaiButtonWeather(view: View) {
        val navigateToDouaiBtnIntent = Intent(this, SecondActivityWeatherDetails::class.java)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val webService = retrofit.create(WebServiceInterface::class.java)
        val callWebServiceWithKey = webService.getJson("2df24a9d6af0495d8f4123409210712", "Douai", "fr")
        callWebServiceWithKey.enqueue(object : Callback<Weather>{
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                val data = response.body()
                navigateToDouaiBtnIntent.putExtra("data", data)
                startActivity(navigateToDouaiBtnIntent)
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.d("ERR", t.message!!)
            }

        })
    }

    fun navigateToSearchButtonWeather(view: View) {
        val navigateToSearchBtnIntent = Intent(this, SecondActivityWeatherDetails::class.java)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val searchInputText = binding.mainActivityTextInput.text.toString()

        val webService = retrofit.create(WebServiceInterface::class.java)
        val callWebServiceWithKey = webService.getJson("2df24a9d6af0495d8f4123409210712", searchInputText, "fr")
        callWebServiceWithKey.enqueue(object : Callback<Weather>{
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                val data = response.body()
                navigateToSearchBtnIntent.putExtra("data", data)
                startActivity(navigateToSearchBtnIntent)
            }
            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.d("ERR", t.message!!)
            }
        })
    }
}

