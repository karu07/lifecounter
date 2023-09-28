package com.gamelot.lifecounter.user.service.model

import com.gamelot.lifecounter.user.repository.entities.UserDAO
import java.time.LocalDate

data class User(
    val name: String,
    val username : String,
    val email : String,
    val settings : GameSettings,
    val role : Role,
    val birthDate : LocalDate
)
