package com.gamelot.lifecounter.test.repo

import com.gamelot.lifecounter.test.repo.entities.SettingsEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SettingsRepository: JpaRepository<SettingsEntity, UUID> {
}