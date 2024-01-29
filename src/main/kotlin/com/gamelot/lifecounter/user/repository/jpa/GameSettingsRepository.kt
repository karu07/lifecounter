package com.gamelot.lifecounter.user.repository.jpa

import com.gamelot.lifecounter.user.repository.entities.GameSettingsDAO
import org.springframework.data.jpa.repository.JpaRepository

interface GameSettingsRepository : JpaRepository<GameSettingsDAO, Long> {
}