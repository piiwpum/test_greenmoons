package exts

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun String.toFormatDate(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val outputFormat = SimpleDateFormat("MMMM d, yyyy", Locale.getDefault())
    return try {
        val date = inputFormat.parse(this)
        outputFormat.format(date)
    } catch (e: Exception) {
        this
    }
}
