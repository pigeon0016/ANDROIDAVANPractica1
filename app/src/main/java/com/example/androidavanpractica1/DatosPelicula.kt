package com.example.androidavanpractica1

import android.content.Context

class DatosPelicula(context: Context?) {
    val context = context

    fun obtenerPeliculas() : ArrayList<Pelicula>
    {
        val tmpArrayList = ArrayList<Pelicula>()

        val pelicula1 = Pelicula(1,"Looper","Rian Johnson","Ciencia Ficcion",4.1,119,"2012")
        tmpArrayList.add(pelicula1)
        val pelicula2 = Pelicula(2,"Close Encounters of the 3 type","Steven Spielberg","Ciencia Ficcion",5.0,135,"1977")
        tmpArrayList.add(pelicula2)
        val pelicula3 = Pelicula(3,"2001: A Space Odysseyr","Stanley Kubrick","Ciencia Ficcion",4.8,142,"1968")
        tmpArrayList.add(pelicula3)
        val pelicula4 = Pelicula(4,"The Arrival","David Twohy","Ciencia Ficcion",3.8,119,"1996")
        tmpArrayList.add(pelicula4)

        return tmpArrayList

    }



    fun obtenerPelicula(idImagen: Int): ArrayList<Pelicula>{
        val todaslaspeliculas = obtenerPeliculas()
        val filtropelicula = ArrayList<Pelicula>()
        todaslaspeliculas.forEach{ pelicula ->
             if (pelicula.idImagen  == idImagen){
                 filtropelicula.add(pelicula)
             }
        }
        return filtropelicula
    }
}

