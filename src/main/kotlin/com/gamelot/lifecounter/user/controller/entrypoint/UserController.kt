package com.gamelot.lifecounter.user.controller.entrypoint

import com.gamelot.lifecounter.test.repo.entities.Persona
import com.gamelot.lifecounter.user.controller.dto.UserCreationDTO
import com.gamelot.lifecounter.user.service.UserService
import com.gamelot.lifecounter.user.service.model.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class UserController (val userService: UserService) {
    @PostMapping("/info")
    fun createNewUser(@RequestBody userCreationDTO: UserCreationDTO): ResponseEntity<Any> {

        val result = userService.createUser(userCreationDTO.toUser())
        if (result) {
            return ResponseEntity.status(201).body("la persona se ha guardado exitosamente")
        } else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("algo malo paso lo sentimos")
    }
}