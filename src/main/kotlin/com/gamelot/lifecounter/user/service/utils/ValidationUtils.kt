package com.gamelot.lifecounter.user.service.utils

import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.regex.Pattern

@Component
class ValidationUtils {
    fun validateAge(birthDate: LocalDate): Boolean {
        val birthYear = birthDate.year
        val legalAgeToDrink = 18
        if (LocalDate.now().year - birthYear < legalAgeToDrink) return false
        return true
    }

    fun validateEmailFormat(email: String): Boolean {
        val emailRegex = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\$")

        if (!emailRegex.matcher(email)
                .matches()
        ) return false
        return true
    }
}