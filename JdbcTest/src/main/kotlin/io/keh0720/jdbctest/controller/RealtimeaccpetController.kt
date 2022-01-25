package io.keh0720.jdbctest.controller

import io.keh0720.jdbctest.dto.Realtimeaccept
import io.keh0720.jdbctest.mapper.RealtimeacceptMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RealtimeaccpetController(
    private final val realtimeacceptMapper: RealtimeacceptMapper
) {
    @GetMapping("/realtimeaccept")
    fun getRealtimeaccept(): List<Realtimeaccept> = realtimeacceptMapper.getRealtimeaccepts()

    @PostMapping("/realtimeaccept")
    fun insertRealtimeaccept(@RequestBody realtimeaccept: Realtimeaccept): Realtimeaccept {
        realtimeacceptMapper.insertRealtimeaccept(realtimeaccept)
        return realtimeaccept
    }
}