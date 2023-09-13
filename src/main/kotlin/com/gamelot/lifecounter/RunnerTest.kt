package com.gamelot.lifecounter

import com.gamelot.lifecounter.test.repo.entities.Persona
import com.gamelot.lifecounter.test.repo.entities.PlayerEntity
import com.gamelot.lifecounter.test.repo.entities.SettingsEntity
import com.gamelot.lifecounter.test.repo.entities.Sex
import com.gamelot.lifecounter.test.repo.PlayerRepository
import com.gamelot.lifecounter.test.repo.SettingsRepository
import mu.KotlinLogging
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.LocalDate
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

        val settings1 = settingsRepository.saveAndFlush(
            SettingsEntity(
            null,
            "setting 1",
            "board negro",
            "texto rojo",
            10
        )
        )

        val settings2 = settingsRepository.saveAndFlush(
            SettingsEntity(
            null,
            "setting 2",
            "borde blanco",
            "texto negro",
            10
        )
        )

        val settings3 = settingsRepository.saveAndFlush(
            SettingsEntity(
            null,
            "setting 3",
            "borde azul",
            "texto amarillo",
            10
        )
        )
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
//
//        val mario = Persona(
//            firstName = "Mario",
//            lastName = "Mendoza",
//            nationality = "Colombiano",
//            sex = Sex.APACHE_HELICOPTER,
//            birthDate = LocalDate.of(1985, 10, 15),
//            availableMoney = BigDecimal.valueOf(150000L),
//            ssn = "12345678",
//            email = "marioMendoza@gmail.com",
//            height = 1.545
//        )
//
//        val zapata = Persona(
//            firstName = "Alejandro",
//            lastName = "Zapata",
//            nationality = "Colombiano",
//            sex = Sex.MALE,
//            birthDate = LocalDate.of(1985, 4, 7),
//            availableMoney = BigDecimal.valueOf(16546416L),
//            ssn = "32456789",
//            email = "alejandrozapata@gmail.com",
//            height = 1.451
//        )
//
//        logger.info { "nuestro primer usuario se llama ${mario.firstName} y su sexo es ${mario.sex}" }
//        logger.info { "nuestro segundo usuario se llama ${zapata.firstName} y su sexo es ${zapata.sex}, ${zapata.availableMoney}, ${zapata.birthDate} ${zapata.height}" }
//        logger.info { "etsito" }
    }
}