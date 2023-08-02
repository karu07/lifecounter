package com.gamelot.lifecounter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LifecounterApplication

fun main(args: Array<String>) {
	runApplication<LifecounterApplication>(*args)
}
