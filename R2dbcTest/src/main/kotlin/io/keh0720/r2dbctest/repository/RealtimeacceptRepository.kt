package io.keh0720.r2dbctest.repository

import io.keh0720.r2dbctest.entity.Realtimeaccept
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface RealtimeacceptRepository : R2dbcRepository<Realtimeaccept, Int>