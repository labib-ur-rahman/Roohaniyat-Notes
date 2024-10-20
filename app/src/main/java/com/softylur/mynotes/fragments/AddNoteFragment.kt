package com.softylur.mynotes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import com.softylur.mynotes.MainActivity
import com.softylur.mynotes.R
import com.softylur.mynotes.databinding.FragmentAddNoteBinding
import com.softylur.mynotes.model.Note
import com.softylur.mynotes.viewmodel.NoteViewModel


class AddNoteFragment : Fragment(R.layout.fragment_add_note) {

    private var addNoteBinding: FragmentAddNoteBinding? = null
    private val binding get() = addNoteBinding!!

    private lateinit var notesViewModel: NoteViewModel
    private lateinit var addNoteView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        addNoteBinding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notesViewModel = (activity as MainActivity).noteViewModel
        addNoteView = view

        binding.addNoteFab.setOnClickListener {
            val noteTitle = binding.addNoteTitle.text.toString().trim()
            val noteContent = binding.addNoteDesc.text.toString().trim()

            if(noteTitle.isNotEmpty()){
                val note = Note(0, noteTitle, noteContent)
                notesViewModel.addNote(note)

                Toast.makeText(addNoteView.context, "Note Saved", Toast.LENGTH_SHORT).show()
                view.findNavController().popBackStack(R.id.homeFragment, false)
            }else{
                binding.addNoteTitle.error = getString(R.string.error_field_required)

                Toast.makeText(addNoteView.context, "Please enter the note title", Toast.LENGTH_SHORT).show()
            }
        }
    }
}