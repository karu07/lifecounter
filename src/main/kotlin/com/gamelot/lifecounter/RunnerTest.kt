package com.gamelot.lifecounter

import com.gamelot.lifecounter.repository.entities.PlayerEntity
import com.gamelot.lifecounter.repository.entities.SettingsEntity
import com.gamelot.lifecounter.repository.repo.PlayerRepository
import mu.KotlinLogging
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class RunnerTest(
    val playerRepository: PlayerRepository
):ApplicationListener<ApplicationReadyEvent> {

    companion object {
        private val logger = KotlinLogging.logger {}
    }

    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        val entity = PlayerEntity(
            null,
            "carlos",
            "emailtest@test.com",
            SettingsEntity(
                null,
                "setting one",
                "board1",
                "board2",
                10
            )

        )
        val result = playerRepository.saveAndFlush(entity)

        val result2 = playerRepository.findByPlayerName(result.playerName)

        logger.info { result2?.email }

    }
}