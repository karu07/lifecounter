package com.gamelot.lifecounter

import com.gamelot.lifecounter.repository.entities.PlayerEntity
import com.gamelot.lifecounter.repository.entities.SettingsEntity
import com.gamelot.lifecounter.repository.repo.PlayerRepository
import com.gamelot.lifecounter.repository.repo.SettingsRepository
import mu.KotlinLogging
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import java.util.Random

@Component
class RunnerTest(
    val playerRepository: PlayerRepository,
    val settingsRepository: SettingsRepository
):ApplicationListener<ApplicationReadyEvent> {

    companion object {
        private val logger = KotlinLogging.logger {}
    }

    override fun onApplicationEvent(event: ApplicationReadyEvent) {

        val settings1 = settingsRepository.saveAndFlush(SettingsEntity(
            null,
            "setting 1",
            "board negro",
            "texto rojo",
            10
        ))

        val settings2 = settingsRepository.saveAndFlush(SettingsEntity(
            null,
            "setting 2",
            "borde blanco",
            "texto negro",
            10
        ))

        val settings3 = settingsRepository.saveAndFlush(SettingsEntity(
            null,
            "setting 3",
            "borde azul",
            "texto amarillo",
            10
        ))
        for (i in 1..1000) {
            val setting = Random().nextInt(1, 4)
            val settingEntity = when(setting) {
                1 -> settings1
                2 -> settings2
                3 -> settings3
                else -> throw Exception("oops")
            }
            val entity = PlayerEntity(
                null,
                "carlos $i",
                "emailtest@test$i.com",
                settingEntity
            )
            val result = playerRepository.saveAndFlush(entity)

            val result2 = playerRepository.findByPlayerName(result.playerName)

            logger.info { result2?.email }
        }

        logger.info { "etsito" }
    }
}