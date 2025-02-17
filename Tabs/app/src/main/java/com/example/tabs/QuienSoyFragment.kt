package com.example.tabs

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class QuienSoyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quien_soy, container, false)

        // Configuración de los TextView con strings.xml
        view.findViewById<TextView>(R.id.tvNombre).text = getString(R.string.nombre, "")
        view.findViewById<TextView>(R.id.tvApellido).text = getString(R.string.apellido, "")
        view.findViewById<TextView>(R.id.tvCarnet).text = getString(R.string.carnet, "")
        view.findViewById<TextView>(R.id.tvTelefono).text = getString(R.string.telefono, "")

        // Botón para abrir WhatsApp
        view.findViewById<Button>(R.id.btnEscribeme).setOnClickListener {
            val phoneNumber = "50312345678"  // Reemplázalo con un número real
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/$phoneNumber"))

            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                // Manejar el error si no hay navegador o WhatsApp instalado
            }
        }

        return view
    }
}
