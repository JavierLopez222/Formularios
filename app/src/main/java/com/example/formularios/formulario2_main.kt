package com.example.formularios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class formulario2_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.formulario2)

        var btnEnviar = findViewById<Button>(R.id.btnEnviar)
        var etNombre = findViewById<TextInputEditText>(R.id.textInputEditTextNombre)
        var etCorreo = findViewById<TextInputEditText>(R.id.textInputEditTextCorreo)
        var etContra = findViewById<TextInputEditText>(R.id.textInputEditTextContra)

        btnEnviar.setOnClickListener{

            var bool1 = validarNombre(etNombre)
            var bool2 = validarCorreo(etCorreo)
            var bool3 = validarContra(etContra)

            if(bool1 && bool2 && bool3){
                var intent = Intent(this, pass::class.java)
                startActivity(intent)
            }
        }


    }
    fun validarNombre(etNombre:TextInputEditText):Boolean{
        var esValido = true
        if(etNombre.text.isNullOrBlank()){
            etNombre.error = "Este campo no puede estar vacío"
            esValido = false
        }
        return esValido
    }
    fun validarCorreo(etCorreo:TextInputEditText):Boolean{
        var esValido = true
        if(etCorreo.text!!.contains("@") && etCorreo.text!!.contains(".")){
            esValido = true
        }else{
            etCorreo.error = "Debe contener '@' y '.'"
        }
        return esValido
    }
    fun validarContra(etContra:TextInputEditText):Boolean{
        var esValido = true
        if(etContra.text!!.length<6){
            etContra.error = "La contraseña debe tener más de 6 carácteres"
            esValido = false
        }
        return esValido
    }
}