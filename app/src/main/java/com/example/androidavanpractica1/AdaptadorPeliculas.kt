package com.example.androidavanpractica1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidavanpractica1.databinding.ElementoListaPeliculaBinding



 class AdaptadorPeliculas (private val context: Context, val lista: ArrayList<Pelicula>,  val onItemListener: OnItemListener) : RecyclerView.Adapter<AdaptadorPeliculas.MyViewHolder>() {

     override fun onCreateViewHolder(
         parent: ViewGroup,
         viewType: Int
     ): AdaptadorPeliculas.MyViewHolder {
         val layoutInflater = LayoutInflater.from(parent.context)
         val binding = ElementoListaPeliculaBinding.inflate(layoutInflater)
         return MyViewHolder(binding, onItemListener)
     }

     override fun onBindViewHolder(holder: AdaptadorPeliculas.MyViewHolder, position: Int) {
         holder.bindData(lista[position])
     }


     override fun getItemCount(): Int {
         return lista.size
     }

     interface OnItemListener {
         fun clickPelicula(lista: Pelicula)
     }


     class MyViewHolder(binding: ElementoListaPeliculaBinding, onItemListener: OnItemListener) :
         RecyclerView.ViewHolder(binding.root), View.OnClickListener { //OK
         private val binding = binding
         private val onItemListener = onItemListener
         private lateinit var lista: Pelicula

         init {
             binding.root.setOnClickListener(this)
         }

         override fun onClick(p0: View?) {
             onItemListener.clickPelicula(lista)
         }

         fun bindData(item: Pelicula) {
             binding.elplvPelicula.setImageResource(R.drawable.looper)

             with(binding) {
                 when (item.idImagen) {
                     1 -> elplvPelicula.setImageResource(R.drawable.looper)
                     2 -> elplvPelicula.setImageResource(R.drawable.closeencounters)
                     3 -> elplvPelicula.setImageResource(R.drawable.oddisey)
                     4 -> elplvPelicula.setImageResource(R.drawable.thearrival)
                 }
                 elpTvTitulo.text = item.titulo
                 elpTvGenero.text = item.genero
                 elpRbCalificacion.rating = item.calificacion.toFloat()
             }
             lista = item
         }

     }
     // aqui haces la referencia al layout de la lista de peliculas


 }
