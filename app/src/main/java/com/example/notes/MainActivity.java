package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NoteRepository noteRepository = new NoteRepository(MainActivity.this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<Note> notes = noteRepository.getAllNotes();
        final NoteListAdapter noteListAdapter = new NoteListAdapter(notes, MainActivity.this);
        recyclerView.setAdapter(noteListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    public void addNote(View view)
    {
        Intent intent = new Intent(MainActivity.this,AddNote.class);
        startActivity(intent);
        finish();
    }
}