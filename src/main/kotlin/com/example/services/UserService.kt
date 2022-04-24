package com.example.services


import com.example.models.User
import com.example.models.Users
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class UserService {

    fun getAllUsers(): List<User> = transaction {
        Users.selectAll().map { Users.toUser(it) }
    }

    fun getUserById(id: Int): List<User> {
        val users = transaction {
            Users.select{Users.id eq id}.map { Users.toUser(it) }
        }

        return users
    }

    fun addUser(user: User) = transaction {
        Users.insert { Users ->
            Users[lastname]=user.lastname
            Users[firstname]=user.firstname
            Users[middlename]=user.middlename
            Users[email]=user.email
            Users[phone]=user.phone
        }
    }
}