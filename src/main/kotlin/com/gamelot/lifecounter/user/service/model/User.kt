package com.gamelot.lifecounter.user.service.model

import java.time.LocalDate

data class User(
    val name: String,
    val username: String,
    val email: String,
    val settings: GameSettings,
    val role: Role,
    val birthDate: LocalDate,
    val auth: String
)
