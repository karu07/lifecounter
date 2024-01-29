package com.gamelot.lifecounter.user.controller.dto

import com.gamelot.lifecounter.user.service.model.GameSettings
import com.gamelot.lifecounter.user.service.model.Role
import com.gamelot.lifecounter.user.service.model.User
import java.time.LocalDate
import java.util.*

data class UserCreationDTO(
    val name: String,
    val lastName: String,
    val email: String,
    val username: String,
    val birthdate: LocalDate,
) {
    fun toUser(): User {
        return User(
            name = "$name $lastName",
            username = username,
            birthDate = birthdate,
            email = email,
            settings = null,
            role = Role.USER,
            auth = UUID.randomUUID().toString()
        )
    }
}
