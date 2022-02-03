package com.ApiRest.controllers

import com.ApiRest.entities.Persona
import com.ApiRest.exception.NotFoundException
import com.ApiRest.exception.ServiceException
import com.ApiRest.services.IPersonaService
import com.ApiRest.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_PERSONAS)
class PersonaController {
    @Autowired
    val personaService: IPersonaService? = null
    @GetMapping("")
    fun getPersonas(): ResponseEntity<List<Persona>> {
        return try{
             ResponseEntity(personaService!!.getPersonas(), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @GetMapping("/{id}")
    fun getPersona(@PathVariable("id") id: Long): ResponseEntity<Persona> {
        return try{
            ResponseEntity(personaService!!.getPersona(id), HttpStatus.OK)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @PostMapping("")
    fun savePersona(@RequestBody persona: Persona): ResponseEntity<Persona> {
        return try{
            personaService!!.savePersona(persona)
            val responseHeader = HttpHeaders()
            responseHeader.set("Location", "${Constants.URL_BASE_PERSONAS}/${persona.id}")
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        }catch (e: ServiceException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @PutMapping("")
    fun updatePersona( @RequestBody persona: Persona): ResponseEntity<Persona> {
        return try{
            personaService!!.updatePersona(persona)
            ResponseEntity(HttpStatus.OK)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
    @DeleteMapping("/{id}")
    fun deletePersona(@PathVariable("id") id: Long): ResponseEntity<Persona> {
        return try{
            personaService!!.deletePersona(id)
            ResponseEntity(HttpStatus.OK)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }catch (e: ServiceException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}