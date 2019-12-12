package com.orlinskas.customviewtask.customView

import android.content.Context

interface FullAirTravel {
    fun setFirstAirport(name: String)
    fun setSecondAirport(name: String)
    fun rebuild(context: Context)
}