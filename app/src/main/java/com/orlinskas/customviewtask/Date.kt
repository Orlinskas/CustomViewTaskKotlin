package com.orlinskas.customviewtask

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

const val YYYY_MM_DD_HH_00 = "yyyy-MM-dd HH:00";
const val YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
const val YYYY_MM_DD = "yyyy-MM-dd";
const val DD_MM = "dd-MM";
const val MM_SS = "mm:ss";
const val HH_MM = "HH:mm";

@SuppressLint("SimpleDateFormat")
fun dateToString(date: Date, format: String) : String {
    return SimpleDateFormat(format).format(date)
}