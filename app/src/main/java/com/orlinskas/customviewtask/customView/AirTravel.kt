package com.orlinskas.customviewtask.customView

import android.content.Context
import android.graphics.Bitmap
import com.orlinskas.customviewtask.City
import java.util.*

interface AirTravel {
    fun calculateFlyTime(dateFrom: Date, dateTo: Date)
    fun setFirstAirport(name: String)
    fun setSecondAirport(name: String)
    fun rebuild(context: Context)
    fun setRaceID(raceId: String, raceId2: String)
    fun setCompanyImage(bitmap: Bitmap, bitmap2: Bitmap)
    fun setCityFrom(city: City, city2: City)
    fun setCityTo(city: City, city2: City)
    fun setDateFrom(date: Date, date2: Date)
    fun setDateTo(date: Date, date2: Date)
}