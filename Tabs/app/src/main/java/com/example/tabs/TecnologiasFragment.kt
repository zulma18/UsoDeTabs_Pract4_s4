package com.example.tabs

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class TecnologiasFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_tecnologias,
            container, false)

        val tvTecnologias =
            view.findViewById<TextView>(R.id.tvTecnologias)
            tvTecnologias.text = "- Kotlin\n- Android\n- SQL Server\n- PHP"


        //btn enviar correo
        view.findViewById<Button>(R.id.btnContactame).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL,
                    arrayOf("prueba123@gmail.com")) //colocar correo real
                putExtra(Intent.EXTRA_SUBJECT, "Me interesa tus servicios")
            }
            startActivity(intent)
        }
        return view
    }
}