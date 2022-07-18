package com.task.common.util

import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale
import java.util.TimeZone

object DateTimeFormatter {
    enum class FormatFrom(val format: String) {
        STORM_GLASS(format = "yyyy-MM-dd'T'HH:mm:ssZ")
    }

    enum class FormatTo(val format: String) {
        HOURS_MINUTES(format = "HH:mm"),
        DAY(format = "d")
    }

    data class DateTimeFormat(val from: FormatFrom, val to: FormatTo)

    fun formatStringDate(
        date: String,
        format: DateTimeFormat,
        withTimeZone: Boolean = true
    ): String = try {
        val simpleDateFormatFrom = SimpleDateFormat(format.from.format, Locale.getDefault())
        if (withTimeZone) simpleDateFormatFrom.timeZone = TimeZone.getDefault()
        val simpleDateFormatTo = SimpleDateFormat(format.to.format, Locale.getDefault())
        simpleDateFormatFrom.parse(date)?.let { simpleDateFormatTo.format(it) } ?: ""
    } catch (e: Exception) {
        e.printStackTrace()
        "Invalid Date"
    }

    fun formatLongDate(
        date: Long,
        to: FormatTo,
        withTimeZone: Boolean = true
    ): String = try {
        val formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.getDefault())
        val dateTime: ZonedDateTime = Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault())
        dateTime.format(formatter)
    } catch (e: Exception) {
        e.printStackTrace()
        "Invalid Date"
    }
}
