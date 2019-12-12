package com.orlinskas.customviewtask

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var airTravel: AirTravel
    private lateinit var airTravel2: AirTravel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        airTravel = findViewById<View>(R.id.activity_main_air_travel) as AirTravel
        airTravel2 = findViewById<View>(R.id.activity_main_air_travel2) as AirTravel
    }

    private fun setContent(airTravel: AirTravel) = airTravel.apply {
        setCityFrom(getRandomCity())
        setCityTo(getRandomCity())
        setRaceID("M" + randomInt(10000..99999) + "o")
        setCompanyImage(getRandomBitmap(applicationContext))
        val dateFrom = getRandomDate()
        val dateTo = getRandomDate()
        setDateFrom(dateFrom)
        setDateTo(dateTo)
        calculateFlyTime(dateFrom, dateTo)
    }

    fun travelClick1(view: View) {
        setContent(airTravel)
    }

    fun travelClick2(view: View) {
        setContent(airTravel2)
    }
}
