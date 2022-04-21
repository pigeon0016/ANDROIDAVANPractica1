package com.example.androidavanpractica1

import android.os.Bundle
import android.view.Menu
import android.widget.LinearLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidavanpractica1.databinding.ActivityMainBinding
import com.example.androidavanpractica1.databinding.ElementoListaPeliculaBinding
import com.example.androidavanpractica1.databinding.FragmentGalleryBinding


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


/*
    private lateinit var adaptadorPeliculas: AdaptadorPeliculas // recycler view
    private lateinit var lista: ArrayList<Pelicula>  // recycler view
    private lateinit var binding2: FragmentGalleryBinding
*/    //private lateinit var _binding: FragmentGalleryBinding  // recycler view
    //*********************************************************+


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        // recycler veiw code*************************************************************************************************
//***********************************************
    /*    generarDatosPrueba()  // cargas la lista
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this) // creas el layout manager
        binding2.amRvPeliculas.setLayoutManager(layoutManager) // pasat la lista al layoutmanager
        adaptadorPeliculas = AdaptadorPeliculas(lista)
        binding2.amRvPeliculas.adapter = adaptadorPeliculas
*/

    }
    /////////////////////////////////////////////////////////////////////

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }





}

