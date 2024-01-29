package com.gamelot.lifecounter.user.service.impl

import com.gamelot.lifecounter.user.repository.entities.GameSettingsDAO
import com.gamelot.lifecounter.user.repository.entities.UserDAO
import com.gamelot.lifecounter.user.repository.jpa.GameSettingsRepository
import com.gamelot.lifecounter.user.repository.jpa.UserRepository
import com.gamelot.lifecounter.user.service.GameSettingsService
import com.gamelot.lifecounter.user.service.model.GameSettings

class GameSettingsImpl(
    private val gameSettingsRepository: GameSettingsRepository
) : GameSettingsService {
    override fun createSettings(gameSettings: GameSettings) {
        gameSettingsRepository.save(GameSettingsDAO.fromGameSettings(gameSettings))
    }
}