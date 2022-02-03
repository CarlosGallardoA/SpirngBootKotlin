package com.ApiRest.repositories

import com.ApiRest.entities.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonaRepository: JpaRepository<Persona, Long>