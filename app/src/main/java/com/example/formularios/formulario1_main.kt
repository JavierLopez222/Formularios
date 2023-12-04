package com.example.formularios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class formulario1_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.formulario1)

        var btnEnviar = findViewById<Button>(R.id.btnEnviar)
        var etNombre = findViewById<TextInputEditText>(R.id.textInputEditTextNombre)
        var etEdad = findViewById<TextInputEditText>(R.id.textInputEditTextEdad)

        btnEnviar.setOnClickListener{
            var bool1 = validarNombre(etNombre)
            var bool2 = validarEdad(etEdad)

            if( bool1 && bool2){
                val intent = Intent(this, pass::class.java)
                startActivity(intent)
            }
        }


    }
    fun validarNombre(etNombre:TextInputEditText):Boolean{
        var esValido = true
        if(etNombre.text.isNullOrBlank() ){
            etNombre.error = "El campo no puede estar vacío"
            esValido = false
        }
        return esValido
    }

    fun validarEdad(etEdad:TextInputEditText): Boolean{
        var esValido = true

        if(etEdad.text.toString().toInt() < 18){
            etEdad.error = "Tienes que ser mayor de 18 años para acceder"
            esValido = false
        }
        return esValido
    }
}