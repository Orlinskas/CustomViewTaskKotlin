package com.orlinskas.customviewtask

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.orlinskas.customviewtask.customView.AirTravel

class MainActivity : AppCompatActivity() {
    private lateinit var airTravel: AirTravel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        airTravel = findViewById<View>(R.id.activity_main_custom_view) as AirTravel
    }

    fun onClick(view: View) {
        airTravel.rebuild(applicationContext)
    }

}
