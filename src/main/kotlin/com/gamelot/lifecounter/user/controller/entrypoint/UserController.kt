package com.gamelot.lifecounter.user.controller.entrypoint

import com.gamelot.lifecounter.user.controller.dto.MailValidationDTO
import com.gamelot.lifecounter.user.controller.dto.UserCreationDTO
import com.gamelot.lifecounter.user.service.GameSettingsService
import com.gamelot.lifecounter.user.service.UserService
import com.gamelot.lifecounter.user.service.utils.exceptions.EmailAlreadyInUseException
import com.gamelot.lifecounter.user.service.utils.exceptions.InvalidAgeException
import com.gamelot.lifecounter.user.service.utils.exceptions.InvalidEmailFormatException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class UserController(
    val userService: UserService,
) {
    @PostMapping("/create-user")
    fun createNewUser(@RequestBody userCreationDTO: UserCreationDTO): ResponseEntity<Any> {

        return try {
            val newUser = userCreationDTO.toUser()
            userService.createUser(newUser)
            ResponseEntity.status(HttpStatus.CREATED)
                .body("el usuario se ha guardado exitosamente, su código de autentificación es ${newUser.auth}")
        } catch (invalidAgeException: InvalidAgeException) {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(invalidAgeException.message)
        } catch (invalidEmailFormatException: InvalidEmailFormatException) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(invalidEmailFormatException.message)
        } catch (emailAlreadyInUseException: EmailAlreadyInUseException) {
            ResponseEntity.status(HttpStatus.CONFLICT).body(emailAlreadyInUseException.message)
        }
    }

    @PutMapping("/validate-mail")
    fun validateMail(@RequestBody mailValidationDTO: MailValidationDTO): ResponseEntity<Any> {

        return if (userService.confirmMail(mailValidationDTO.mail, mailValidationDTO.auth, mailValidationDTO.password)) {
            ResponseEntity.status(HttpStatus.OK)
                .body("Validación exitosa")
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validacion no exitosa")
        }
    }
}