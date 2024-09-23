package com.alissonfarias.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val btnEnter = findViewById<Button>(R.id.btnEnter)

        btnEnter.setOnClickListener {
            val name = etName.text.toString()
            if (name.isNotEmpty()) {
                val intent = Intent(this, NoteActivity::class.java)
                intent.putExtra("user_name", name)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Digite um nome", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
