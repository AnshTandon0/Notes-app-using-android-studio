package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements NoteListAdapter.ItemClickListener {

    List<Note> notes;
    NoteRepository noteRepository;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteRepository = new NoteRepository(MainActivity.this);
        recyclerView = findViewById(R.id.recyclerView);
        try {
            notes = noteRepository.getAllNotes();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final NoteListAdapter noteListAdapter = new NoteListAdapter(notes, getApplicationContext(),this);
        recyclerView.setAdapter(noteListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu,menu);
        return true;
    }

    public void deleteAll(MenuItem item)
    {
        noteRepository.deleteAll();
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
        finish();
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
        finish();
    }
}