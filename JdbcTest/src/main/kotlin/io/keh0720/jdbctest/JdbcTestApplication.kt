package io.keh0720.jdbctest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JdbcTestApplication

fun main(args: Array<String>) {
    runApplication<JdbcTestApplication>(*args)
}
