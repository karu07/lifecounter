package com.gamelot.lifecounter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class LifeCounterApplication

fun main(args: Array<String>) {
	runApplication<LifeCounterApplication>(*args)
}
