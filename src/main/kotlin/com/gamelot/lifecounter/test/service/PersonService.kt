package com.gamelot.lifecounter.test.service

import com.gamelot.lifecounter.test.controller.dto.PrivateInformationDTO
import com.gamelot.lifecounter.test.repo.entities.Persona
import com.gamelot.lifecounter.test.repo.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(
    val personRepository: PersonRepository
) {

    fun findPersona(id: Long): Persona? {
        return findMeById(id)
    }

    fun savePersona(persona: Persona): Boolean {
        personRepository.save(persona)
        return true
    }

    private fun findMeById(id: Long): Persona? {
        return personRepository.findById(id).orElse(null)
    }

    fun validatePersonInformation(id: Long, password: String): PrivateInformationDTO? {
        val person = personRepository.findById(id).get()
        if (person.password == password) {
            return person.toPrivateInformation()
        } else {
            return null
        }
    }

    fun findAllByFirstName(name: String): List<Persona>? {
        return personRepository.findAllByFirstName(name)
    }
}