package com.gamelot.lifecounter.user.repository.entities

import com.gamelot.lifecounter.user.service.model.GameSettings
import com.gamelot.lifecounter.user.service.model.Role
import com.gamelot.lifecounter.user.service.model.User
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import java.util.*


@Table("user")
@Entity
data class UserDAO(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val name: String,
    val username: String,
    val email: String,
    val settings : String,
    val role : String,
    val birthDate : LocalDate,
    val password : String,
    val isMailVerified : Boolean,
) {
    constructor() : this(null, "", "", "", "", "", LocalDate.now(), "", false) {

    }

    companion object {
        fun fromUser(user: User): UserDAO {
            return UserDAO(
                null,
                user.name,
                user.username,
                user.email,
                user.settings.settingsName,
                user.role.name,
                user.birthDate,
                UUID.randomUUID().toString(),
                false
            )
        }
    }
}

