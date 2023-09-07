package com.gamelot.lifecounter.repository.repo

import com.gamelot.lifecounter.repository.entities.SettingsEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SettingsRepository: JpaRepository<SettingsEntity, UUID> {
}