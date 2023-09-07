package com.gamelot.lifecounter.test.entities

import jakarta.persistence.*
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "persona")
data class Persona(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null,
    val firstName: String,
    val lastName: String,
    val nationality: String,
    @Enumerated(EnumType.STRING)
    val sex: Sex,
    val birthDate: LocalDate,
    val availableMoney: BigDecimal,
    val ssn: String,
    val email: String,
    val height: Double
    // expresion numerica Int, Float, Long, BigDecimal
    ) {
    constructor() : this(null, "", "", "", Sex.APACHE_HELICOPTER, LocalDate.MIN, BigDecimal.ZERO, "", "", 0.0)
}
