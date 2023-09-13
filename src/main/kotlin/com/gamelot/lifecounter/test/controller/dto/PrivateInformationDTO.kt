package com.gamelot.lifecounter.test.controller.dto

import java.math.BigDecimal

data class PrivateInformationDTO(
    val ssn: String,
    val availableMoney: BigDecimal,
    val password: String
)
