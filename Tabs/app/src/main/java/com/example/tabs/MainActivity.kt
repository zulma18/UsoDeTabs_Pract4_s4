package com.example.tabs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar el Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)  // Establecer el Toolbar como ActionBar

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_nav_view)

        // Configurar el comportamiento de la navegación al seleccionar íconos
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            var title: String = ""

            when (item.itemId) {
                R.id.quienSoyFragment -> {
                    selectedFragment = QuienSoyFragment()
                    title = getString(R.string.quien_soy)
                }
                R.id.queEstudioFragment -> {
                    selectedFragment = QueEstudioFragment()
                    title = getString(R.string.que_estudio)
                }
                R.id.tecnologiasFragment -> {
                    selectedFragment = TecnologiasFragment()
                    title = getString(R.string.tecnologias)
                }
            }

            // Reemplazar el fragmento actual con el fragmento seleccionado
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, selectedFragment)
                    .commit()

                // Actualizar el título del Toolbar
                supportActionBar?.title = title
            }

            true
        }

        // Inicializar el fragmento por defecto si es necesario
        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.quienSoyFragment
        }
    }
}

