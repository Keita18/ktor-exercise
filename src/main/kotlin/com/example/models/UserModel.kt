package com.example.models

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object Users : Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val lastname: Column<String> = varchar("firstname", 255)
    val firstname: Column<String> = varchar("lastname", 255)
    val middlename: Column<String> = varchar("middlename", 255)
    val email: Column<String> = varchar("email", 100)
    val phone: Column<String> = varchar("phone", 100)

    override val primaryKey = PrimaryKey(id, name="PK_User_ID")

    fun toUser(row: ResultRow): User = User(
        id=row[id],
        lastname=row[lastname],
        firstname=row[firstname],
        middlename=row[middlename],
        email=row[email],
        phone=row[phone]
    )
}

data class User(
    val id: Int,
    val lastname: String,
    val firstname: String,
    val middlename: String,
    val email: String,
    val phone: String
)