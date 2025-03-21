package com.dominio.aplicacionescolar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {

    // Variables globales para almacenar el correo y la contraseña
    companion object {
        var correoGuardado: String? = null
        var contraseñaGuardada: String? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        // Configuración para padding del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNombre = findViewById<EditText>(R.id.et_nombre)
        val etCorreo = findViewById<EditText>(R.id.et_correo)
        val etContraseña = findViewById<EditText>(R.id.et_contraseña)
        val etRepetirContraseña = findViewById<EditText>(R.id.et_repetircontraseña)
        val btnRegistrarse = findViewById<Button>(R.id.btn_registrarse)

        btnRegistrarse.setOnClickListener {
            val nombre = etNombre.text.toString()
            val correo = etCorreo.text.toString()
            val contraseña = etContraseña.text.toString()
            val repetirContraseña = etRepetirContraseña.text.toString()


            if (nombre == "" && correo == "" && contraseña == "" && repetirContraseña == ""){

                Toast.makeText(this, "Debes llenar el Registro", Toast.LENGTH_LONG).show()

            } else{

             // Validar si las contraseñas coinciden
                if (contraseña == repetirContraseña) {
                // Guardar el correo y la contraseña en variables de la clase companion
                    correoGuardado = correo
                    contraseñaGuardada = contraseña

                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show()

                    // Ir a la pantalla de login (MainActivity)
                    val intent = Intent(this, MainActivity::class.java)

                }else {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
                }

        }

        val tvGoLogin = findViewById<TextView>(R.id.tv_go_to_login)
        tvGoLogin.setOnClickListener {
            goToLogin()
        }
    }

    private fun goToLogin() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}


