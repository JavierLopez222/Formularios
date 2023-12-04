package com.example.formularios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.text.isDigitsOnly
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Calendar
import java.util.Date


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


        etFecha.setOnClickListener{
            val builder = MaterialDatePicker.Builder.datePicker()
            val picker = builder.build()

            picker.addOnPositiveButtonClickListener {
                etFecha.setText(picker.headerText)
            }

            picker.show(supportFragmentManager, "jeje")
        }

        btnEnviar.setOnClickListener{
            var bool1 = validarCorreo(etCorreo)
            var bool2 = validarContra(etContra)
            var bool3 = validarNombre(etNombre)
            var bool4 = validarCP(etCP)
            var bool5 = validarFecha(etFecha)

            if(bool1 && bool2 && bool3 && bool4 && bool5){
                var intent = Intent(this, pass::class.java)
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
        val patterm = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)[a-zA-Z\\\\d]{7,}\$"
        var esValido = true
        if(etContra.text!!.length<7){
            etContra.error = "Debe tener más de 7 carácteres, contener un número, una mayúscula y una minúscula"
            esValido = false
        }
        return esValido
    }

    fun validarNombre(etNombre:TextInputEditText):Boolean{
        var esValido = true
        if(etNombre.text!!.isNullOrBlank()){
            etNombre.error = "Este campo no puede estar vacío"
            esValido = false
        }
        return esValido
    }
    fun validarCP(etCP:TextInputEditText):Boolean{
        var esValido = false
        if(etCP.text!!.isDigitsOnly()){
            esValido = true
        }
        return esValido
    }

    fun validarFecha(etFecha:TextInputEditText):Boolean{
        var esValido = true
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val current = formatter.format(time)


        val fechaFormateada = formatter.format(Date(etFecha.text.toString()))

        // Log.v("fechaPicker", fechaFormateada.toString())
        // Log.v("fechaPicker", current)

        var edad = fechaFormateada.split("-").get(0).toInt() - etFecha.text?.split("-")?.get(0)!!.toInt() ?: 0
        if (edad < 18){
            esValido = false
            etFecha.error = "El usuario debe ser mayor de edad"
        }
        return esValido
    }
}