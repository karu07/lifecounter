package com.gamelot.lifecounter.user.repository.entities

import com.gamelot.lifecounter.user.service.model.GameSettings
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("gameSettings")
@Entity
data class GameSettingsDAO(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val password: String?,
    val isVerified: Boolean,
) {
    constructor() : this(null, "", false) {
    }

    companion object {
        fun fromGameSettings(gameSettings: GameSettings): GameSettingsDAO {
            return GameSettingsDAO(
                null,
                gameSettings.password,
                gameSettings.isVerified,
            )
        }
    }
}

