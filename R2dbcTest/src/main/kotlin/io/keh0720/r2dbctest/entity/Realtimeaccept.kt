package io.keh0720.r2dbctest.entity

import org.springframework.data.annotation.Id
import java.text.SimpleDateFormat
import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

data class Realtimeaccept(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var seq: Int = 0,
    var type: String = "A",
    var regDate: String = SimpleDateFormat("YYYY-MM-DD hh:mm:ss", Locale.KOREA).format(Date()),
    var contents: String? = null,
    var subjects: String? = null
)