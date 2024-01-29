package com.gamelot.lifecounter.user.service

import com.gamelot.lifecounter.user.service.model.GameSettings

interface GameSettingsService {
    fun createSettings(gameSettings: GameSettings)
}