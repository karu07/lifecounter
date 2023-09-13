package com.gamelot.lifecounter.test.repo.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("settings")
@Entity
data class SettingsEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: UUID? = null,
        val settingName: String,
        val boardRight: String,
        val boardLeft: String,
        val size: Int,
) {
        constructor() : this(null, "", "", "", 0) {

        }
}
