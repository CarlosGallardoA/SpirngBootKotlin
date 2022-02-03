package com.ApiRest.services

import com.ApiRest.entities.Persona

interface IPersonaService {
    fun getPersonas(): List<Persona>
    fun getPersona(id: Int): Persona
    fun savePersona(persona: Persona): Persona
    fun deletePersona(id: Long)
}