package com.gamelot.lifecounter.user.service.impl

import com.gamelot.lifecounter.user.service.UserService
import com.gamelot.lifecounter.user.service.model.User

class UserServiceImpl : UserService {
    override fun createUser(user: User): Boolean {
        if(validateMail(user.email) && validateAge(user.birthDate)){

        }
    }

    private fun validateMail(email: String): Boolean {
        val emailRegex = Regex.fromLiteral("^[/w-/.]+@([/w-]+/.)+[/w-]{2,4}$")
        if (!emailRegex.containsMatchIn(email)){
            return false
        }

        if()
    }

    override fun getUser(id: Long): User {
        TODO("Not yet implemented")
    }

    override fun confirmMail(mail: String, auth: String): Boolean {
        TODO("Not yet implemented")
    }

}