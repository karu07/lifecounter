package com.gamelot.lifecounter.user.controller.entrypoint

import com.gamelot.lifecounter.test.repo.entities.Persona
import com.gamelot.lifecounter.user.controller.dto.UserCreationDTO
import com.gamelot.lifecounter.user.service.UserService
import com.gamelot.lifecounter.user.service.impl.InvalidAgeException
import com.gamelot.lifecounter.user.service.impl.InvalidMailException
import com.gamelot.lifecounter.user.service.model.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class UserController(val userService: UserService) {
    @PostMapping("/create-user")
    fun createNewUser(@RequestBody userCreationDTO: UserCreationDTO): ResponseEntity<Any> {

        return try {
            userService.createUser(userCreationDTO.toUser())
            ResponseEntity.status(201).body("el usuario se ha guardado exitosamente")
        }catch (ageException: InvalidAgeException) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("${ageException.message} \n\t ${ageException.stackTraceToString()}")
        } catch (mailException: InvalidMailException) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("${mailException.message} \n\t ${mailException.stackTraceToString()}")
        }
    }
}