package com.ApiRest.services

import com.ApiRest.entities.Persona
import com.ApiRest.repositories.PersonaRepository
import org.springframework.beans.factory.annotation.Autowired

class PersonaService : IPersonaService {
    @Autowired
    val presonaRepository : PersonaRepository? = null
    override fun getPersonas(): List<Persona> {
        TODO("Not yet implemented")
    }

    override fun getPersona(id: Int): Persona {
        TODO("Not yet implemented")
    }

    override fun savePersona(persona: Persona): Persona {
        TODO("Not yet implemented")
    }

    override fun deletePersona(id: Long) {
        TODO("Not yet implemented")
    }
}