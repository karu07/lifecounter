package com.gamelot.lifecounter.test.repo.entities

import com.gamelot.lifecounter.test.controller.dto.PersonNameDTO
import com.gamelot.lifecounter.test.controller.dto.PrivateInformationDTO
import jakarta.persistence.*
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "persona")
data class Persona( //DTO //DAO //DO
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
    val height: Double,
    val password: String
    // expresion numerica Int, Float, Long, BigDecimal
    ) {
    fun toPersonName(): PersonNameDTO {
        return PersonNameDTO(
            name = this.firstName,
            lastName = this.lastName
        )
    }

    fun toPrivateInformation(): PrivateInformationDTO {
        return PrivateInformationDTO(
            ssn = this.ssn,
            availableMoney = this.availableMoney,
            password = this.password
        )
    }

    // SOLID
    // single responsability
    // open closed principle
    // liskov principle
    // interface segregation
    // dependency inversion

    constructor() : this(null, "", "", "", Sex.APACHE_HELICOPTER, LocalDate.MIN, BigDecimal.ZERO, "", "", 0.0, "")
}
