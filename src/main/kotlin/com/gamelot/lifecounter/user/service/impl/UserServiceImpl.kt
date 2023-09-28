package com.gamelot.lifecounter.user.service.impl

import com.gamelot.lifecounter.user.repository.entities.UserDAO
import com.gamelot.lifecounter.user.repository.jpa.UserRepository
import com.gamelot.lifecounter.user.service.UserService
import com.gamelot.lifecounter.user.service.model.User
import java.time.LocalDate

class UserServiceImpl (
    val userRepository: UserRepository
): UserService {
    override fun createUser(user: User): Boolean {
        if(validateMail(user.email) && validateAge(user.birthDate)){
            userRepository.save(UserDAO.fromUser(user))
            return true
        }
        return false
    }

    private fun validateAge(birthDate: LocalDate): Boolean {
        val birthYear =  birthDate.year
        val legalAgeToDrink = 18
        if (LocalDate.now().year - birthYear >= legalAgeToDrink ){
            return true
        }
        return false
    }

    private fun validateMail(email: String): Boolean {
        val emailRegex = Regex.fromLiteral("^[/w-/.]+@([/w-]+/.)+[/w-]{2,4}$")
        if (!emailRegex.containsMatchIn(email)){
            return false
        }
        if(userRepository.findAllByEmail(email).isEmpty()){
            return true
        }
        return false
    }

    override fun getUser(id: Long): User {
        TODO("Not yet implemented")
    }

    override fun confirmMail(mail: String, auth: String): Boolean {
        TODO("Not yet implemented")
    }

}