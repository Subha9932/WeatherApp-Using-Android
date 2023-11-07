package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val locationData: MutableMap<String, WeatherData> = mutableMapOf()
    private lateinit var usr: TextView
    private lateinit var usr1: TextView
    private lateinit var usr2: TextView
    private lateinit var usr3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locationData["Delhi"] = WeatherData("Delhi", "39C", "49%")
        locationData["Mumbai"] = WeatherData("Mumbai", "35C", "60%")
        locationData["Pune"] = WeatherData("Pune", "31C", "67%")
        locationData["Kolkata"] = WeatherData("Kolkata", "25C", "40%")
        locationData["Phagwara"] = WeatherData("Phagwara", "23C", "61%")
        locationData["Jalandhar"] = WeatherData("Jalandhar", "38C", "52%")
        locationData["Kashmir"] = WeatherData("Kashmir", "15C", "90%")
        locationData["Lakhnow"] = WeatherData("Lakhnow", "21C", "56%")
        locationData["Kerala"] = WeatherData("Kerala", "37C", "51%")
        locationData["Panjub"] = WeatherData("Panjub", "34C", "57%")
        locationData["Puruliya"] = WeatherData("Puruliya", "23C", "68%")
        locationData["Haryana"] = WeatherData("Haryana", "38C", "58%")

        usr = findViewById(R.id.cityname)
        usr1 = findViewById(R.id.temp)
        usr2 = findViewById(R.id.textView19)
        usr3 = findViewById(R.id.temp1)


        val searchView = findViewById<SearchView>(R.id.srch)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (locationData.containsKey(query)) {
                    val weatherData = locationData[query]
                    updateUI(weatherData)
                } else {
                    Toast.makeText(applicationContext, "Weather data not found for $query", Toast.LENGTH_SHORT).show()
                }
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
    }

    fun updateUI(weatherData: WeatherData?) {
        weatherData?.let {
            usr.text = it.location
            usr1.text = it.temperature
            usr3.text = it.temperature
            usr2.text = it.humidity
        }
    }
}
