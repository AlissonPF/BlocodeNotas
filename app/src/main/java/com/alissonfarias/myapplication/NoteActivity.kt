package com.alissonfarias.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NoteActivity : AppCompatActivity() {
    private val notes = mutableListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        val userName = intent.getStringExtra("user_name")
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = "Bem-vindo, $userName"

        initializeNotes()

        val btnShowNotes = findViewById<Button>(R.id.btnShowNotes)
        val btnAddNote = findViewById<Button>(R.id.btnAddNote)

        btnShowNotes.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, NoteListFragment())
                .commit()
        }

        btnAddNote.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, NoteEditFragment())
                .commit()
        }
    }

    private fun initializeNotes() {
        notes.add(Note("Primeira Nota", "Conteúdo da primeira nota."))
        notes.add(Note("Segunda Nota", "Conteúdo da segunda nota."))
        notes.add(Note("Terceira Nota", "Conteúdo da terceira nota."))
    }

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun getNotes(): List<Note> {
        return notes
    }
}

