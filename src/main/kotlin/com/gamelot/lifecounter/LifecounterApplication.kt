package com.gamelot.lifecounter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class LifecounterApplication

fun main(args: Array<String>) {
	runApplication<LifecounterApplication>(*args)
}
