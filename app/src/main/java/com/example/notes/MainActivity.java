package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NoteListAdapter.ItemClickListener {

    List<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NoteRepository noteRepository = new NoteRepository(MainActivity.this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        notes = noteRepository.getAllNotes();
        final NoteListAdapter noteListAdapter = new NoteListAdapter(notes, getApplicationContext(),this);
        recyclerView.setAdapter(noteListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    public void addNote(View view)
    {
        Intent intent = new Intent(MainActivity.this,AddNote.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this,DisplayNotes.class);
        intent.putExtra("title",notes.get(position).getTitle());
        startActivity(intent);
    }
}