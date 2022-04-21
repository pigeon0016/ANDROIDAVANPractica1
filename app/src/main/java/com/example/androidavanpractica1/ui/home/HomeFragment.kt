package com.example.androidavanpractica1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidavanpractica1.databinding.FragmentGalleryBinding
import com.example.androidavanpractica1.databinding.FragmentHomeBinding
import java.util.regex.Pattern

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root

        //binding.btnpress.setOnClickListener{validar()}
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding)
        {
            btnpress.setOnClickListener {
                if( validar() ){
                    Toast.makeText(context,"OK",Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(context,"Error ",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

   /* override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    */


    private fun  validateemail() : Boolean{
        // creamos la funciomn donde queremos que nos regrese un boleano (true or false

        // recuperamos el valor de lo que se metio en el email
        val email = binding.email.editText?.text.toString()
        return if(email.isEmpty()){
            binding.email.error = "El texto no puede estar vacio"
            false
        }else if(PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
            binding.email.error = "Escribe un email valido"
            false
        }else{
            binding.email.error = null
            true
        }
    }


    private fun validapass() : Boolean{
        val pass = binding.password.editText?.text.toString()
        val passwordRegex = Pattern.compile(
            "^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +        //at least 1 lower case letter
                    "(?=.*[A-Z])" +        //at least 1 upper case letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$"
        )
        return if (pass.isEmpty()){
            binding.password.error = "campo esta vacio"
            false
        }else if(!passwordRegex.matcher(pass).matches()){
            binding.password.error = "password es debil"
            false
        }else{
            binding.password.error = null
            true
        }

    }

  private fun validar(): Boolean {
      val resultado = arrayOf(validateemail(),validapass())
      if(false in resultado){
          return false
      } else{ return true}
      //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()

  }



}