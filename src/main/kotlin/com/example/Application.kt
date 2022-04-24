package com.example

import com.example.models.User
import com.example.models.Users
import com.example.services.UserService
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.myapp() {
    install(ContentNegotiation) {
        jackson()
    }

    DatabaseFactory.init()
    transaction {
        SchemaUtils.create(Users)

        Users.insert {
            it[lastname] = "Keita"
            it[firstname] = "Aboubacar"
            it[middlename] = "Sidiki"
            it[email] = "askeita@yahoo.com"
            it[phone] = "+7 950 223 64 31"
        }

        Users.insert {
            it[lastname] = "Jack"
            it[firstname] = "Jackson"
            it[middlename] = "John"
            it[email] = "jj@gmail.com"
            it[phone] = "+7 800 000 00 00"
        }

    }
    val userService = UserService()


    install(Routing) {

        route("/users") {
            get ("/") {
                call.respond(userService.getAllUsers())
            }

            get ("/{id}") {
                val id = call.parameters["id"]!!.toInt()
                val users = userService.getUserById(id)
                call.respond(users)
            }

            post("/") {
                val user = call.receive<User>()
                userService.addUser(user)
                call.respond(user)
            }
        }
    }
}

fun main() {
    embeddedServer(
        Netty,
        watchPaths = listOf("ktor-starter"),
        module = Application::myapp,
        port = 8080
    ).start(wait = true)
}
