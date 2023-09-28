package com.gamelot.lifecounter.user.service
import com.gamelot.lifecounter.user.service.model.User

interface UserService {
    fun createUser(user : User) : Boolean
    fun getUser(id : Long) : User
    fun confirmMail (mail : String, auth : String) : Boolean

}