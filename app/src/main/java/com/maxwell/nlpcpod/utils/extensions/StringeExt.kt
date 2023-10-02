package com.maxwell.nlpcpod.utils.extensions

import org.ocpsoft.prettytime.PrettyTime
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

fun String.formatDate():String?{
    val prettyTime = PrettyTime()

    val isoDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH)

    val parsedDate=isoDateFormat.parse(this)
    val parsedIsoDate = isoDateFormat.parse(this)

    return try {
       val formattedDate=prettyTime.format(parsedIsoDate)
        if (formattedDate.contains("months")) return dateFormat.format(parsedDate!!).toString() else formattedDate
    } catch (e: ParseException) {
        parsedIsoDate?.toString()
    }
}