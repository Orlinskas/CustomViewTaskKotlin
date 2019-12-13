package com.orlinskas.customviewtask.customView

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import com.orlinskas.customviewtask.*
import kotlinx.android.synthetic.main.custom_view_air_travel.view.*
import java.util.*
import android.graphics.Paint.Align
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class AirTravelView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr), AirTravel {

    private val ta = context.obtainStyledAttributes(attrs, R.styleable.AirTravelView)
    private var paint = Paint()
    private var rect = Rect()

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

            val companyImageBot  = ta.getResourceId(R.styleable.AirTravelView_companyImageBot, 0)
            if (companyImageBot != 0) {
                val drawable = AppCompatResources.getDrawable(context, companyImageBot)
                custom_view_air_travel_iv_companyLogo_bot.setImageDrawable(drawable)
            }

            val raceIDBot = ta.getString(R.styleable.AirTravelView_raceIDBot)
            val cityCodeFromBot = ta.getString(R.styleable.AirTravelView_cityCodeFromBot)
            val cityCodeToBot = ta.getString(R.styleable.AirTravelView_cityCodeToBot)
            val cityNameFromBot = ta.getString(R.styleable.AirTravelView_cityNameFromBot)
            val cityNameToBot = ta.getString(R.styleable.AirTravelView_cityNameToBot)
            val timeFromBot = ta.getString(R.styleable.AirTravelView_timeFromBot)
            val timeToBot = ta.getString(R.styleable.AirTravelView_timeToBot)
            val dateFromBot = ta.getString(R.styleable.AirTravelView_dateFromBot)
            val dateToBot = ta.getString(R.styleable.AirTravelView_dateToBot)
            val timeInFlyBot = ta.getString(R.styleable.AirTravelView_timeInFlyBot)

            val secondAirport = ta.getString(R.styleable.AirTravelView_secondAirport)
            val firstAirport = ta.getString(R.styleable.AirTravelView_firstAirport)

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

            custom_viev_air_travel_race_id_bot.text = raceIDBot
            custom_view_air_travel_tv_city_from_code_bot.text = cityCodeFromBot
            custom_view_air_travel_tv_city_from_name_bot.text = cityNameFromBot
            custom_view_air_travel_tv_city_to_code_bot.text = cityCodeToBot
            custom_view_air_travel_tv_city_to_name_bot.text = cityNameToBot
            custom_view_air_travel_tv_city_from_time_bot.text = timeFromBot
            custom_view_air_travel_tv_city_to_time_bot.text = timeToBot
            custom_view_air_travel_tv_time_in_fly_bot.text = timeInFlyBot
            custom_view_air_travel_tv_date_bot.text = dateFromBot
            custom_view_air_travel_tv_date2_bot.text = dateToBot

            custom_view_full_air_travel_tv_travel.text = firstAirport
            custom_view_full_air_travel_tv_travel1.text = secondAirport
        } finally {
            ta.recycle()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = resources.getColor(R.color.colorCustomView);
        rect.set((width / 2), 30, width - 30, 90)
        canvas?.drawRect(rect, paint)

        if (canvas != null) {
            drawRectText(custom_viev_air_travel_race_id.text.toString(), canvas, rect)
        }

    }

    private fun drawRectText(text: String, canvas: Canvas, r: Rect) {
        paint.textSize = 40F
        paint.textAlign = Align.CENTER
        paint.color = Color.BLACK
        val width = r.width()
        val height = r.height()

        val numOfChars = paint.breakText(text, true, width.toFloat(), null)
        val start = (text.length - numOfChars) / 2
        canvas.drawText(
            text,
            start,
            start + numOfChars,
            r.exactCenterX(),
            r.exactCenterY() + (height / 4),
            paint
        )
    }

    override fun setRaceID(raceId: String, raceId2: String) {
        custom_viev_air_travel_race_id.text = raceId
        custom_viev_air_travel_race_id_bot.text = raceId2
        invalidate()
    }

    override fun setCompanyImage(bitmap: Bitmap, bitmap2: Bitmap) {
        custom_view_air_travel_iv_companyLogo.setImageBitmap(bitmap)
        custom_view_air_travel_iv_companyLogo_bot.setImageBitmap(bitmap2)
        invalidate()
    }

    override fun setCityFrom(city: City, city2: City) {
        custom_view_air_travel_tv_city_from_code.text = city.code
        custom_view_air_travel_tv_city_from_name.text = city.fullName

        custom_view_air_travel_tv_city_from_code_bot.text = city2.code
        custom_view_air_travel_tv_city_from_name_bot.text = city2.fullName
        invalidate()
    }

    override fun setCityTo(city: City, city2: City) {
        custom_view_air_travel_tv_city_to_code.text = city.code
        custom_view_air_travel_tv_city_to_name.text = city.fullName

        custom_view_air_travel_tv_city_to_code_bot.text = city2.code
        custom_view_air_travel_tv_city_to_name_bot.text = city2.fullName
        invalidate()
    }

    override fun setDateFrom(date: Date, date2: Date) {
        val time = dateToString(date, HH_MM)
        val date = dateToString(date, YYYY_MM_DD)
        custom_view_air_travel_tv_city_from_time.text = time
        custom_view_air_travel_tv_date.text = date

        val time2 = dateToString(date2, HH_MM)
        val date2 = dateToString(date2, YYYY_MM_DD)
        custom_view_air_travel_tv_city_from_time_bot.text = time2
        custom_view_air_travel_tv_date_bot.text = date2
        invalidate()
    }

    override fun setDateTo(date: Date, date2: Date) {
        val time = dateToString(date, HH_MM)
        val date = dateToString(date, YYYY_MM_DD)
        custom_view_air_travel_tv_city_to_time.text = time
        custom_view_air_travel_tv_date2.text = date

        val time2 = dateToString(date2, HH_MM)
        val date2 = dateToString(date2, YYYY_MM_DD)
        custom_view_air_travel_tv_city_to_time_bot.text = time2
        custom_view_air_travel_tv_date2_bot.text = date2
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

    override fun setFirstAirport(name: String) {
        custom_view_full_air_travel_tv_travel.text = name
    }

    override fun setSecondAirport(name: String) {
        custom_view_full_air_travel_tv_travel1.text = name
    }

    override fun rebuild(context: Context) {
        val cityFrom = getRandomCity()
        val cityFrom2 = getRandomCity()
        val cityTo = getRandomCity()
        val cityTo2 = getRandomCity()
        val dateFrom = getRandomDate()
        val dateFrom2 = getRandomDate()
        val dateTo = getRandomDate()
        val dateTo2 = getRandomDate()
        val raceId = " Регулярный - " + "M" + randomInt(10000..99999) + "k "
        val raceId2 = " Регулярный - " + "M" + randomInt(10000..99999) + "k "
        val bitmap = getRandomBitmap(context)
        val bitmap2 = getRandomBitmap(context)

        setRaceID(raceId, raceId2)
        setCompanyImage(bitmap, bitmap2)
        setCityFrom(cityFrom, cityFrom2)
        setCityTo(cityTo, cityTo2)
        setDateFrom(dateFrom, dateFrom2)
        setDateTo(dateTo, dateTo2)
        calculateFlyTime(dateFrom, dateTo)
        setFirstAirport("Центральный аэропорт " + cityFrom.fullName)
        setSecondAirport("Не центральный аэропорт " + cityTo.fullName)

        invalidate()
    }
}