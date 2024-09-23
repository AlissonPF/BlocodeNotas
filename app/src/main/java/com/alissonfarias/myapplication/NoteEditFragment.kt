package com.alissonfarias.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NoteEditFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NoteEditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_note_edit, container, false)

        val etTitle = view.findViewById<EditText>(R.id.etTitle)
        val etContent = view.findViewById<EditText>(R.id.etContent)
        val btnSave = view.findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            val title = etTitle.text.toString()
            val content = etContent.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                val note = Note(title, content)
                val activity = activity as NoteActivity
                activity.addNote(note)

                // Volta à lista de notas
                activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, NoteListFragment())
                    .commit()
            } else {
                Toast.makeText(activity, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
