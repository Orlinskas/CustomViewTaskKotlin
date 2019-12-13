package com.orlinskas.customviewtask

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.orlinskas.customviewtask.customView.AirTravel
import com.orlinskas.customviewtask.customView.OldCustomProgressBar

class MainActivity : AppCompatActivity() {
    private lateinit var airTravel: AirTravel
    private lateinit var progressBar: OldCustomProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        airTravel = findViewById<View>(R.id.activity_main_custom_view) as AirTravel
        progressBar = findViewById<View>(R.id.customProgressBar) as OldCustomProgressBar
        progressBar.setColor(R.color.colorCustomProgressBar)
        progressBar.setStrokeWidth(10F)
        progressBar.intermediate(true)
    }

    fun onClick(view: View) {
        airTravel.rebuild(applicationContext)
        progressBar.start()
    }

}
