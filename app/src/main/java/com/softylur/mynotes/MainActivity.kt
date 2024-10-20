package com.softylur.mynotes

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.softylur.mynotes.database.NoteDatabase
import com.softylur.mynotes.databinding.ActivityMainBinding
import com.softylur.mynotes.repository.NoteRepository
import com.softylur.mynotes.viewmodel.NoteViewModel
import com.softylur.mynotes.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {


    lateinit var noteViewModel: NoteViewModel
    private val binding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(LayoutInflater.from(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupViewModel()
    }

    private fun setupViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)
        noteViewModel = ViewModelProvider(this, viewModelProviderFactory)[NoteViewModel::class.java]
    }
}