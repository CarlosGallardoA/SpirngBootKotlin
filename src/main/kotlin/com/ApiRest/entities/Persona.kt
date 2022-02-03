package com.ApiRest.entities

import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "persona")
data class Persona (
   val dni: Long =0,
    val nombre: String = "",
    val apellido: String = "",
    val lDate : LocalDate? = null) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
}