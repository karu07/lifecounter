package com.gamelot.lifecounter.test.repo

import com.gamelot.lifecounter.test.entities.Persona
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository: JpaRepository<Persona, Long>