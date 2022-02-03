package com.ApiRest.entities

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "persona")
data class Persona (
   val dni: Long =0,
    val nombre: String = "",
    val apellido: String = "",
    val date : Date? = null) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
}