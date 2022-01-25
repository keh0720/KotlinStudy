package io.keh0720.jdbctest.dto

import java.text.SimpleDateFormat
import java.util.*

data class Realtimeaccept(
    var seq: Int = 0,
    var type: String = "A",
    var regDate: String = SimpleDateFormat("YYYY-MM-DD hh:mm:ss", Locale.KOREA).format(Date()),
    var contents: String? = null,
    var subjects: String? = null
)
