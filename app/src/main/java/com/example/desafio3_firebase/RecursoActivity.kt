package com.example.desafio3_firebase

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecursoActivity : AppCompatActivity() {
    lateinit var lblTitulo: TextView
    lateinit var lblEnlace: TextView
    lateinit var lblTipo: TextView
    lateinit var lblDescripcion: TextView
    lateinit var lblId: TextView
    lateinit var imagen: ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recurso)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val resourceId = intent.getStringExtra("idRecurso")
        val titulo = intent.getStringExtra("titulo")
        val urlImagen = intent.getStringExtra("urlImagen")
        val descripcion = intent.getStringExtra("descripcion")
        val enlace   = intent.getStringExtra("enlace")
        val tipo = intent.getStringExtra("tipo")
        // Inicializar el TextView lblTitulo

        lblId = findViewById(R.id.lblId)
        lblTitulo = findViewById(R.id.lblTitulo)
        lblDescripcion = findViewById(R.id.lblDescripcion)
        lblEnlace = findViewById(R.id.lblEnlace)
        lblTipo = findViewById(R.id.lblTipo)
        imagen = findViewById(R.id.imageView)
        // Asignar el valor del ID del recurso al TextView lblTitulo
        lblId.text = resourceId
        lblTitulo.text = titulo
        lblDescripcion.text = descripcion
        lblEnlace.text = enlace
        lblTipo.text = tipo
        Picasso.get().load(urlImagen).resize(750,350) // Establece el tamaño máximo
            .centerInside() // Opcional: escala la imagen para que se ajuste dentro del tamaño máximo sin cambiar la relación de aspecto
            .into(imagen)

    }
}