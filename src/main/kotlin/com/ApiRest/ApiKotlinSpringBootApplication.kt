package com.ApiRest

import com.ApiRest.entities.Persona
import com.ApiRest.repositories.PersonaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SpringBootApplication
class ApiKotlinSpringBootApplication:CommandLineRunner{
	@Autowired
	val personaRepository: PersonaRepository?=null
	override fun run(vararg args: String?) {
		val formater = DateTimeFormatter.ofPattern("dd/MM/yyyy")
		val persona1 = Persona(12312312312,"Juan","Perez", LocalDate.parse("12/12/1990",formater))
		personaRepository?.save(persona1)
	}
}

fun main(args: Array<String>) {
	runApplication<ApiKotlinSpringBootApplication>(*args)
}
