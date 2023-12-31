package com.gamelot.lifecounter.test.repo.entities

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Entity
@Table(name = "player")
data class PlayerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val playerName: String,
    val email: String,
    @ManyToOne(cascade = [CascadeType.MERGE])
    val settings: SettingsEntity
) {
    constructor() : this(null, "", "", SettingsEntity())
}
