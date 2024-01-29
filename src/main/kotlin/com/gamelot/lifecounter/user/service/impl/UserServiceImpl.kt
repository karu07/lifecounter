package com.gamelot.lifecounter.user.service.impl

import com.gamelot.lifecounter.user.repository.entities.UserDAO
import com.gamelot.lifecounter.user.repository.jpa.UserRepository
import com.gamelot.lifecounter.user.service.UserService
import com.gamelot.lifecounter.user.service.model.User
import com.gamelot.lifecounter.user.service.utils.ValidationUtils
import com.gamelot.lifecounter.user.service.utils.exceptions.EmailAlreadyInUseException
import com.gamelot.lifecounter.user.service.utils.exceptions.EmailNotFoundException
import com.gamelot.lifecounter.user.service.utils.exceptions.InvalidAgeException
import com.gamelot.lifecounter.user.service.utils.exceptions.InvalidEmailFormatException
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class UserServiceImpl(
    val userRepository: UserRepository,
    val validationUtils: ValidationUtils
) : UserService {
    override fun createUser(user: User) {

        if (!validationUtils.validateAge(user.birthDate)) throw InvalidAgeException()
        validateMail(user.email)
        userRepository.save(UserDAO.fromUser(user))
    }


    private fun validateMail(email: String) {

        if (!validationUtils.validateEmailFormat(email)) {
            throw InvalidEmailFormatException(email)
        }

        if (userRepository.findAllByEmail(email)
                .isNotEmpty()
        ) throw EmailAlreadyInUseException(email)

    }

    override fun getUser(id: Long): User {
        TODO("Not yet implemented")
    }

    override fun confirmMail(mail: String, auth: String, password: String): Boolean {
        val user = userRepository.findByEmail(mail)?.toUser() ?: throw EmailNotFoundException(mail)
        return when (auth == user.auth) {
            true -> {
                user.settings.password = password
                user.settings.isVerified = true
                userRepository.save(UserDAO.fromUser(user))
                true
            }

            else -> false
        }
    }


}