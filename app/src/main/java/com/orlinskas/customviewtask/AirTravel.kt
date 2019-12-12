package com.orlinskas.customviewtask

import android.graphics.Bitmap
import java.util.*

interface AirTravel {
    fun setCompanyImage(bitmap: Bitmap)
    fun setRaceID(raceId: String)
    fun setCityFrom(city: City)
    fun setCityTo(city: City)
    fun setDateFrom(date: Date)
    fun setDateTo(date: Date)
    fun calculateFlyTime(dateFrom: Date, dateTo: Date)
}