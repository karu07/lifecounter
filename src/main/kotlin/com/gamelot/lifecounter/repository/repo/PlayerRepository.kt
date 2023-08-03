package com.gamelot.lifecounter.repository.repo

import com.gamelot.lifecounter.repository.entities.PlayerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PlayerRepository: JpaRepository<PlayerEntity, UUID> {

    fun findByPlayerName(playerName: String): PlayerEntity?
}