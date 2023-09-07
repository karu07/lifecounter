package com.gamelot.lifecounter.test.controller

import com.gamelot.lifecounter.test.entities.Persona
import com.gamelot.lifecounter.test.repo.PersonRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class PersonController(
    val personRepository: PersonRepository
) {


    @GetMapping("info/{id}")
    fun imprintPerson(@PathVariable("id") id: Long): ResponseEntity<Any> {

        val response = personRepository.findById(id)
        if (response.isPresent) {
            return ResponseEntity.ok().body(response)
        }
        return ResponseEntity.noContent().build()
    }

    @PostMapping("/info")
    fun savePerson(@RequestBody person: Persona): ResponseEntity<Any> {

        personRepository.save(person)
        return ResponseEntity.status(201).body("la persona se ha guardado exitosamente")

    }
}