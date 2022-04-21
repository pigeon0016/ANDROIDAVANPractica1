package com.example.androidavanpractica1

import java.io.Serializable

data class Pelicula (
    // atributos de nuestra clase pelicula
var idImagen: Int,
var titulo: String,
var director: String,
var genero: String,
var calificacion: Double,
var duracion: Int,
var fecha: String
        ) //: Serializable // queremos pasarlos entre avctividades para eso necesitamos para q esta calse pueda transitirse entre los activities
// estos datos tienen qpasarse a un serializable