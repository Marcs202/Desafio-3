package com.example.desafio3_firebase

import adapter.RecursoAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import com.firebase.ui.database.FirebaseRecyclerOptions
import model.Recurso

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecursoAdapter
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Inicializa Firebase Realtime Database
        database = FirebaseDatabase.getInstance()

        // Referencia al RecyclerView
        recyclerView = findViewById(R.id.recyclerView)

        // Configura el LinearLayoutManager para el RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Obtiene una referencia a tu base de datos
        val databaseReference = database.reference.child("recursos")

        // Configura las opciones para el adaptador FirebaseRecyclerAdapter
        val options = FirebaseRecyclerOptions.Builder<Recurso>()
            .setQuery(databaseReference, Recurso::class.java)
            .build()

        // Inicializa el adaptador con las opciones configuradas
        adapter = RecursoAdapter(options)

        // Asigna el adaptador al RecyclerView
        recyclerView.adapter = adapter
        adapter.startListening()
    }

    // Anula onStart() para comenzar a observar cambios en el adaptador



}