package io.keh0720.jdbctest.mapper

import io.keh0720.jdbctest.dto.Realtimeaccept
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Repository
@Mapper
interface RealtimeacceptMapper {
    @Select("SELECT * FROM realtimeaccept")
    fun getRealtimeaccepts(): List<Realtimeaccept>

    @Insert("INSERT INTO r2dbc.realtimeaccept (type, reg_date, contents, subjects) VALUES (#{ra.type}, NOW(), #{ra.contents}, #{ra.subjects})")
    fun insertRealtimeaccept(@Param("ra") realtimeaccept: Realtimeaccept)
}