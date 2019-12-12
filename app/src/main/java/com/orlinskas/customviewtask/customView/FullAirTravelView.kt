package com.orlinskas.customviewtask.customView

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.orlinskas.customviewtask.*
import kotlinx.android.synthetic.main.custom_view_full_air_travel.view.*

class FullAirTravelView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr), FullAirTravel {

    private val ta = context.obtainStyledAttributes(attrs, R.styleable.FullAirTravelView)
    private lateinit var airTravel: AirTravel
    private lateinit var airTravel2: AirTravel

    init {
        init(attrs)
    }

    @SuppressLint("CustomViewStyleable")
    private fun init(attrs: AttributeSet?) {
        View.inflate(context, R.layout.custom_view_full_air_travel, this)
        airTravel = findViewById<View>(R.id.custom_view_full_air_travel_travel_1) as AirTravel
        airTravel2 = findViewById<View>(R.id.custom_view_full_air_travel_travel_2) as AirTravel
        ta.recycle()
    }

    override fun setFirstAirport(name: String) {
        custom_view_full_air_travel_tv_travel.text = name
    }

    override fun setSecondAirport(name: String) {
        custom_view_full_air_travel_tv_travel1.text = name
    }

    override fun rebuild(context: Context) {
        setContent(context, airTravel)
        setContent(context, airTravel2)
        invalidate()
    }

    private fun setContent(context: Context, airTravel: AirTravel) = airTravel.apply {
        setCityFrom(getRandomCity())
        setCityTo(getRandomCity())
        setRaceID("M" + randomInt(10000..99999) + "o")
        setCompanyImage(getRandomBitmap(context))
        val dateFrom = getRandomDate()
        val dateTo = getRandomDate()
        setDateFrom(dateFrom)
        setDateTo(dateTo)
        calculateFlyTime(dateFrom, dateTo)
    }
}