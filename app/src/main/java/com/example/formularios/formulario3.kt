package com.example.formularios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class formulario3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario3)

        var etCorreo = findViewById<TextInputEditText>(R.id.textInputEditTextCorreo)
        var etContra = findViewById<TextInputEditText>(R.id.textInputEditTextContra)
        var etNombre = findViewById<TextInputEditText>(R.id.textInputEditTextNombre)
        var etCP = findViewById<TextInputEditText>(R.id.textInputEditTextCP)
        var etFecha = findViewById<TextInputEditText>(R.id.textInputEditTextFecha)
        var btnEnviar = findViewById<Button>(R.id.btnEnviar)

        btnEnviar.setOnClickListener{
            var bool1 = validarCorreo(etCorreo)
            var bool2 = validarContra(etContra)

            if(bool1 && bool2){
                var intent = Intent(this, formulario2_2::class.java)
                startActivity(intent)
            }
        }
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
        if(etContra.text!!.length<7){
            etContra.error = "Debe tener más de 7 carácteres, contener un número, una mayúscula y una minúscula"
            esValido = false
        }
        return esValido
    }
}