package com.orlinskas.customviewtask

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.custom_view_air_travel.view.*
import java.util.*


class AirTravelView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr), AirTravel {

    private val ta = context.obtainStyledAttributes(attrs, R.styleable.AirTravelView)

    init {
        init(attrs)
    }

    @SuppressLint("CustomViewStyleable")
    private fun init(attrs: AttributeSet?) {
        View.inflate(context, R.layout.custom_view_air_travel, this)
        try {
            val companyImage  = ta.getResourceId(R.styleable.AirTravelView_companyImage, 0)
            if (companyImage != 0) {
                val drawable = AppCompatResources.getDrawable(context, companyImage)
                custom_view_air_travel_iv_companyLogo.setImageDrawable(drawable)
            }
            val raceID = ta.getString(R.styleable.AirTravelView_raceID)
            val cityCodeFrom = ta.getString(R.styleable.AirTravelView_cityCodeFrom)
            val cityCodeTo = ta.getString(R.styleable.AirTravelView_cityCodeTo)
            val cityNameFrom = ta.getString(R.styleable.AirTravelView_cityNameFrom)
            val cityNameTo = ta.getString(R.styleable.AirTravelView_cityNameTo)
            val timeFrom = ta.getString(R.styleable.AirTravelView_timeFrom)
            val timeTo = ta.getString(R.styleable.AirTravelView_timeTo)
            val dateFrom = ta.getString(R.styleable.AirTravelView_dateFrom)
            val dateTo = ta.getString(R.styleable.AirTravelView_dateTo)
            val timeInFly = ta.getString(R.styleable.AirTravelView_timeInFly)

            custom_viev_air_travel_race_id.text = raceID
            custom_view_air_travel_tv_city_from_code.text = cityCodeFrom
            custom_view_air_travel_tv_city_from_name.text = cityNameFrom
            custom_view_air_travel_tv_city_to_code.text = cityCodeTo
            custom_view_air_travel_tv_city_to_name.text = cityNameTo
            custom_view_air_travel_tv_city_from_time.text = timeFrom
            custom_view_air_travel_tv_city_to_time.text = timeTo
            custom_view_air_travel_tv_time_in_fly.text = timeInFly
            custom_view_air_travel_tv_date.text = dateFrom
            custom_view_air_travel_tv_date2.text = dateTo
        } finally {
            ta.recycle()
        }
    }

    override fun setRaceID(raceId: String) {
        custom_viev_air_travel_race_id.text = raceId
        invalidate()
    }

    override fun setCompanyImage(bitmap: Bitmap) {
        custom_view_air_travel_iv_companyLogo.setImageBitmap(bitmap)
        invalidate()
    }

    override fun setCityFrom(city: City) {
        custom_view_air_travel_tv_city_from_code.text = city.code
        custom_view_air_travel_tv_city_from_name.text = city.fullName
        invalidate()
    }

    override fun setCityTo(city: City) {
        custom_view_air_travel_tv_city_to_code.text = city.code
        custom_view_air_travel_tv_city_to_name.text = city.fullName
        invalidate()
    }

    override fun setDateFrom(date: Date) {
        val time = dateToString(date, HH_MM)
        val date = dateToString(date, YYYY_MM_DD)
        custom_view_air_travel_tv_city_from_time.text = time
        custom_view_air_travel_tv_date.text = date
        invalidate()
    }

    override fun setDateTo(date: Date) {
        val time = dateToString(date, HH_MM)
        val date = dateToString(date, YYYY_MM_DD)
        custom_view_air_travel_tv_city_to_time.text = time
        custom_view_air_travel_tv_date2.text = date
        invalidate()
    }

    @SuppressLint("SetTextI18n")
    override fun calculateFlyTime(dateFrom: Date, dateTo: Date) {
        val diff = dateFrom.time - dateTo.time
        val seconds = diff / 1000
        val minutes = seconds / 60
        val hours = minutes / 60
        val days = hours / 24
        custom_view_air_travel_tv_time_in_fly.text = "In fly $hours hours"
        invalidate()
    }
}