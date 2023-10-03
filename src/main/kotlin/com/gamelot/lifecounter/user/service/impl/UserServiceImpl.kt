package com.gamelot.lifecounter.user.service.impl

import com.gamelot.lifecounter.user.repository.entities.UserDAO
import com.gamelot.lifecounter.user.repository.jpa.UserRepository
import com.gamelot.lifecounter.user.service.UserService
import com.gamelot.lifecounter.user.service.model.User
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.regex.Pattern

class InvalidAgeException(message: String) : Exception(message)
class InvalidMailException(message: String) : Exception(message)

@Service
class UserServiceImpl(
    val userRepository: UserRepository
) : UserService {
    override fun createUser(user: User) {
        try {
            validateAge(user.birthDate)
            validateMail(user.email)
            userRepository.save(UserDAO.fromUser(user))
        } catch (ageException: InvalidAgeException) {
            throw ageException
        } catch (mailException: InvalidMailException) {
            throw mailException
        }

    }

    private fun validateAge(birthDate: LocalDate) {
        val birthYear = birthDate.year
        val legalAgeToDrink = 18
        if (LocalDate.now().year - birthYear < legalAgeToDrink) throw InvalidAgeException("El usuario no puede ser menor de edad")

    }

    private fun validateMail(email: String) {
        val emailRegex = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\$")

        if (!emailRegex.matcher(email)
                .matches()
        ) throw InvalidMailException("Ingrese un correo con un formato válido, ej: nombre@dominio.com")

        if (userRepository.findAllByEmail(email)
                .isNotEmpty()
        ) throw InvalidMailException("Este correo ya está en uso, por favor ingrese otro")

    }

    override fun getUser(id: Long): User {
        TODO("Not yet implemented")
    }

    override fun confirmMail(mail: String, auth: String): Boolean {
        TODO("Not yet implemented")
    }

}