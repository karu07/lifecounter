package com.gamelot.lifecounter.user.repository.entities

import com.gamelot.lifecounter.user.service.model.GameSettings
import com.gamelot.lifecounter.user.service.model.Role
import com.gamelot.lifecounter.user.service.model.User
import jakarta.persistence.*
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
    @OneToOne(cascade = [CascadeType.MERGE])
    val settings: GameSettings = GameSettings(),
    val role: String,
    val birthDate: LocalDate,
    val auth: String
) {
    //constructor() : this(null, "", "", "", GameSettings(), "", LocalDate.now(), "")

    fun toUser(): User {
        return User(
            this.name,
            this.username,
            this.email,
            this.settings,
            Role.valueOf(this.role),
            this.birthDate,
            this.auth
        )
    }
    companion object {
        fun fromUser(user: User): UserDAO {
            return UserDAO(
                null,
                user.name,
                user.username,
                user.email,
                user.settings,
                user.role.name,
                user.birthDate,
                user.auth
            )
        }
    }
}

