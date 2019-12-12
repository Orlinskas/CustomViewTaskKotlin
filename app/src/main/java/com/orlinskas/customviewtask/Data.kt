package com.orlinskas.customviewtask

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.util.*
import kotlin.random.Random.Default.nextInt

fun getRandomCity(): City {
    val city1 = City("KHA", "Kharkov")
    val city2 = City("KUI", "Kiev")
    val city3 = City("VLN", "Vilnius")
    val city4 = City("KUP", "Kupjansk")
    val city5 = City("ODS", "Odessa")
    val city6 = City("RIG", "Riga")

    val cities: Array<City> = arrayOf(city1, city2, city3, city4, city5, city6)

    return cities[randomInt(0..5)]
}

fun randomInt(range: IntRange): Int {
    return range.first + nextInt(range.last - range.first) }

fun getRandomDate(): Date {
    val date1 = plusSomeHours(Date())
    val date2 = plusSomeHours(Date())
    val date3 = plusSomeHours(Date())
    val date4 = plusSomeHours(Date())
    val date5 = plusSomeHours(Date())
    val date6 = plusSomeHours(Date())

    val dates: Array<Date> = arrayOf(date1, date2, date3, date4, date5, date6)

    return dates[randomInt(0..5)]
}

fun getRandomBitmap(context: Context): Bitmap {
    val bitmap1 = BitmapFactory.decodeResource(context.resources, R.drawable.company_logo)
    val bitmap2 = BitmapFactory.decodeResource(context.resources, R.drawable.company_logo2)

    val bitmaps: Array<Bitmap> = arrayOf(bitmap1, bitmap2)
    val randomNumber = randomInt(0..2)

    return bitmaps[randomNumber]
}

fun plusSomeHours(date: Date): Date {
    val calendar = Calendar.getInstance()
    calendar.time = date
    calendar.add(Calendar.HOUR_OF_DAY, randomInt(0..10))
    return calendar.time
}