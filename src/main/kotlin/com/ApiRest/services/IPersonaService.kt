package com.ApiRest.services

import com.ApiRest.entities.Persona
import org.springframework.stereotype.Service

@Service
interface IPersonaService {
    fun getPersonas(): List<Persona>
    fun getPersona(id: Long): Persona
    fun savePersona(persona: Persona): Persona
    fun updatePersona(persona: Persona): Persona
    fun deletePersona(id: Long)
}