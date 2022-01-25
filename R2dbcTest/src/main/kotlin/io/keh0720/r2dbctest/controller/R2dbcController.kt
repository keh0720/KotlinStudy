package io.keh0720.r2dbctest.controller

import io.keh0720.r2dbctest.entity.Realtimeaccept
import io.keh0720.r2dbctest.repository.RealtimeacceptRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class R2dbcController(
    private final val realtimeacceptRepository: RealtimeacceptRepository
) {
    @GetMapping("/realtimeaccept")
    fun getRealtimeaccept(): Flux<Realtimeaccept> {
        return realtimeacceptRepository.findAll()
    }

    @PostMapping("/realtimeaccept", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createRealtimeaccept(@RequestBody realtimeaccept: Realtimeaccept): Mono<Realtimeaccept> =
        realtimeacceptRepository.save(realtimeaccept)

}