package com.example.formulaonesport

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val agilidade = findViewById<EditText>(R.id.editAgilidade)
        val forca = findViewById<EditText>(R.id.editForca)
        val desempenho = findViewById<EditText>(R.id.editDesempenho)
        val foco = findViewById<EditText>(R.id.editFoco)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        btnCalcular.setOnClickListener {
            val agilidadeStr = agilidade.text.toString()
            val forcaStr = forca.text.toString()
            val desempenhoStr = desempenho.text.toString()
            val focoStr = foco.text.toString()

            if (agilidadeStr.isBlank() || forcaStr.isBlank() || desempenhoStr.isBlank() || focoStr.isBlank()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            } else {
                val agilidadeValue = agilidadeStr.toDouble()
                val forcaValue = forcaStr.toDouble()
                val desempenhoValue = desempenhoStr.toDouble()
                val focoValue = focoStr.toDouble()

                val indice = (agilidadeValue + forcaValue + desempenhoValue + focoValue) / 4

                val intent = Intent(this, SegundaActivity::class.java)
                intent.putExtra("indicePiloto", indice)
                startActivity(intent)
            }
        }

        btnLimpar.setOnClickListener {
            agilidade.text.clear()
            forca.text.clear()
            desempenho.text.clear()
            foco.text.clear()
            Toast.makeText(this, "Campos limpos!", Toast.LENGTH_SHORT).show()
        }
    }
}
