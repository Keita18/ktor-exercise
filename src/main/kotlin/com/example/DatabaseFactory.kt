package com.example


import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database

object DatabaseFactory {
    private val config = HikariConfig().apply {
        jdbcUrl         = "jdbc:postgresql://database:5432/ktor-app"
        driverClassName = "org.postgresql.Driver"
        username        = "username"
        password        = "secret"
        maximumPoolSize = 10
    }
    private val dataSource = HikariDataSource(config)

    fun init() {
        Database.connect(dataSource)
        val flyway = Flyway.configure()
            .dataSource(dataSource)
            .load()
        flyway.migrate()
    }

}