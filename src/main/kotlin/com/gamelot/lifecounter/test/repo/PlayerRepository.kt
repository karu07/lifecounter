package com.gamelot.lifecounter.test.repo

import com.gamelot.lifecounter.test.repo.entities.PlayerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PlayerRepository: JpaRepository<PlayerEntity, UUID> {

    fun findByPlayerName(playerName: String): PlayerEntity?
}