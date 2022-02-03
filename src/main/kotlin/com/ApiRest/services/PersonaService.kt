package com.ApiRest.services

import com.ApiRest.entities.Persona
import com.ApiRest.exception.NotFoundException
import com.ApiRest.exception.ServiceException
import com.ApiRest.repositories.PersonaRepository
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class PersonaService : IPersonaService {
    @Autowired
    val personaRepository : PersonaRepository? = null
    @Throws(ServiceException::class)
    override fun getPersonas(): List<Persona> {
        try{
            return personaRepository!!.findAll()
        }catch (e: Exception){
            throw ServiceException(e.message)
        }
    }
    @Throws(ServiceException::class, NotFoundException::class)
    override fun getPersona(id: Long): Persona {
        val op: Optional<Persona>
        try{
            op = personaRepository!!.findById(id)
        }catch (e: Exception){
            throw ServiceException(e.message)
        }
        if(!op.isPresent){
            throw NotFoundException("No se encontro la persona con id: $id")
        }
        return op.get()
    }

    @Throws(ServiceException::class)
    override fun savePersona(persona: Persona): Persona {
        try{
            return personaRepository!!.save(persona)
        }catch (e: Exception){
            throw ServiceException(e.message)
        }
    }

    override fun updatePersona(persona: Persona): Persona {
        try{
            return personaRepository!!.save(persona)
        }catch (e: Exception){
            throw ServiceException(e.message)
        }
    }

    override fun deletePersona(id: Long) {
        val op: Optional<Persona>
        try{
            op = personaRepository!!.findById(id)
        }catch (e: Exception){
            throw ServiceException(e.message)
        }
        if(!op.isPresent){
            throw NotFoundException("No se encontro la persona con id: $id")
        }else{
            try{
                personaRepository!!.deleteById(id)
            }catch (e: Exception){
                throw ServiceException(e.message)
            }
        }
    }
}