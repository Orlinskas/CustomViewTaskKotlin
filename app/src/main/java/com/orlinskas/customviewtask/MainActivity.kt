package com.orlinskas.customviewtask

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.orlinskas.customviewtask.customView.FullAirTravel

class MainActivity : AppCompatActivity() {
    private lateinit var fullAirTravel: FullAirTravel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fullAirTravel = findViewById<View>(R.id.activity_main_custom_view) as FullAirTravel
    }

    fun onClick(view: View) {
        fullAirTravel.rebuild(applicationContext)
    }

}
