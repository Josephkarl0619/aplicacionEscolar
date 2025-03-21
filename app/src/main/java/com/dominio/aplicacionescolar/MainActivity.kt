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

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Configuración para padding del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etcorreoElectronico = findViewById<EditText>(R.id.et_correoElectronico)
        val etcontraseña = findViewById<EditText>(R.id.et_contraseñaLogin)
        val btniniciarSesion = findViewById<Button>(R.id.btn_iniciarSesion)

        btniniciarSesion.setOnClickListener {
            val correo = etcorreoElectronico.text.toString()
            val contraseña = etcontraseña.text.toString()

            // Validar si el correo y la contraseña coinciden con los guardados en RegisterActivity
            if (correo == RegisterActivity.correoGuardado && contraseña == RegisterActivity.contraseñaGuardada) {
                Toast.makeText(this, "¡Bienvenido!", Toast.LENGTH_LONG).show()
                // Aquí puedes redirigir a la pantalla principal de la aplicación o donde quieras
            } else {
                Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        val tvGoRegister = findViewById<TextView>(R.id.tv_go_to_register)
        tvGoRegister.setOnClickListener {
            goToRegister()
        }
    }

    private fun goToRegister() {
        val i = Intent(this, RegisterActivity::class.java)
        startActivity(i)
    }
}

