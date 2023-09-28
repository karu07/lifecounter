package com.gamelot.lifecounter.test.controller

import com.gamelot.lifecounter.test.repo.entities.Persona
import com.gamelot.lifecounter.test.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class PersonController(
    val personService: PersonService
) {


    //DAO //DTO //DO
    @GetMapping("name/{id}")
    fun imprintPerson(@PathVariable("id") id: Long): ResponseEntity<Any> {

        val response = personService.findPersona(id)?.toPersonName()
        if (response != null) {
            return ResponseEntity.ok().body(response)
        }
        return ResponseEntity.noContent().build()
    }

    @GetMapping("name/{id}/{password}")
    fun validatePersonInfo(@PathVariable("id") id: Long, @PathVariable("password") password: String): ResponseEntity<Any> {
        val response = personService.validatePersonInformation(id, password)
        return if (response == null) {
            ResponseEntity.status(HttpStatus.FORBIDDEN).body("access denied")
        } else ResponseEntity.ok().body(response)
    }

    @GetMapping("first-name/{name}")
    fun findByFirstName(@PathVariable("name") name: String): ResponseEntity<Any> {
        return ResponseEntity.ok().body(personService.findAllByFirstName(name))
    }

    @PostMapping("/info")
    fun savePerson(@RequestBody person: Persona): ResponseEntity<Any> {

        val result = personService.savePersona(person)
        return if (result) {
            ResponseEntity.status(201).body("la persona se ha guardado exitosamente")
        } else ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("algo malo paso lo sentimos")
    }

   // ejercicio de arbol binario
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
//    class Solution {
//        public TreeNode invertTree(TreeNode root) {
//            if(root != null) {
//                return new TreeNode(root.val, invertTree(root.right), invertTree(root.left));
//            }
//            else {
//                return null;
//            }
//
//        }
//    }
}