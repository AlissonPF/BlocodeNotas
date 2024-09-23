package com.alissonfarias.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NoteListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NoteListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_note_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvNotes)

        val activity = activity as NoteActivity
        val notes = activity.getNotes()

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = NoteAdapter(notes)

        return view
    }
}
