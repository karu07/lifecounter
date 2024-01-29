package com.gamelot.lifecounter.user.repository.jpa

import com.gamelot.lifecounter.user.repository.entities.UserDAO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserDAO,Long> {
    fun findAllByEmail(email: String): List<UserDAO>

    fun findByEmail(email:String) : UserDAO?
}