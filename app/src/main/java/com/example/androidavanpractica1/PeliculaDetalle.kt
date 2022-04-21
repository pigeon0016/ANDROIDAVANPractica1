package com.example.androidavanpractica1

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidavanpractica1.databinding.PeliculadetalleBinding

class PeliculaDetalle : AppCompatActivity() {

    private lateinit var binding : PeliculadetalleBinding
    var idImagen : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PeliculadetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        if (savedInstanceState == null){
            val bundle = intent.extras
            if (bundle != null){
                idImagen = bundle.getInt("idImagen",0)
            }else{
                idImagen = savedInstanceState?.getSerializable("idImagen") as Int
            }
        }
        val pelicula: ArrayList<Pelicula> = DatosPelicula(applicationContext).obtenerPelicula(idImagen)
       println("**++** $pelicula")
        with(binding){
            when(pelicula[0].idImagen){
                1 -> {detalleimagen.setImageResource(R.drawable.looper)}
                2 -> {detalleimagen.setImageResource(R.drawable.closeencounters)}
                3 -> {detalleimagen.setImageResource(R.drawable.oddisey)}
                4 -> {detalleimagen.setImageResource(R.drawable.thearrival)}
                }
            detalletitulo.text = pelicula[0].titulo
        }
        }

    }



