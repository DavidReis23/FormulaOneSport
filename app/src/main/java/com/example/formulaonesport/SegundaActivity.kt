package com.example.formulaonesport

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class SegundaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.segunda_activity)

        val imagePiloto = findViewById<ImageView>(R.id.imagePiloto)
        val textDescricao = findViewById<TextView>(R.id.textDescricao)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)
        val btnVerVideo = findViewById<Button>(R.id.btnVerVideo)

        val indice = intent.getDoubleExtra("indicePiloto", 0.0)
        Toast.makeText(this, "Índice recebido: $indice", Toast.LENGTH_SHORT).show()

        val piloto = when {
            indice <= 7.0 -> {
                imagePiloto.setImageResource(R.drawable.vertappen)
                textDescricao.text = "Você é como Verstappen: ágil, técnico e focado!"
                "verstappen"
            }
            indice < 8.5 -> {
                imagePiloto.setImageResource(R.drawable.hamilton)
                textDescricao.text = "Você se parece com Hamilton: equilibrado e preciso!"
                "hamilton"
            }
            else -> {
                imagePiloto.setImageResource(R.drawable.senna)
                textDescricao.text = "Você é o Senna do grupo: lenda, rápido e inspirador!"
                "senna"
            }
        }

        btnVerVideo.setOnClickListener {
            val intent = Intent(this, VideoActivity::class.java)
            intent.putExtra("piloto", piloto)
            startActivity(intent)
        }

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}
