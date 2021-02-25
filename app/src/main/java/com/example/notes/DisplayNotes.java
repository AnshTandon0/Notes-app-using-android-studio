package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.Menu;
import android.widget.Toast;

public class DisplayNotes extends AppCompatActivity {

    NoteRepository noteRepository;
    Note note;

    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_notes);
        noteRepository = new NoteRepository(this);
        note = noteRepository.search(getIntent().getStringExtra("title"));
        content = findViewById(R.id.content);
        content.setText(note.getContent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.display_menu,menu);
        return true;
    }

    public void update(MenuItem item)
    {
        Intent intent = new Intent(DisplayNotes.this,UpdateNotes.class);
        intent.putExtra("title",note.getTitle());
        intent.putExtra("content",note.getContent());
        startActivity(intent);
        finish();
    }

    public void delete(MenuItem item)
    {
        Toast.makeText(this, "Note Deleted Successfully", Toast.LENGTH_SHORT).show();
        noteRepository.delete(note);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }


}