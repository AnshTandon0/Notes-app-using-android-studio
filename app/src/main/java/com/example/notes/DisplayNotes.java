package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayNotes extends AppCompatActivity {

    NoteRepository noteRepository;
    Note note;

    TextView title, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_notes);
        noteRepository = new NoteRepository(this);
        note = noteRepository.search(getIntent().getStringExtra("title"));
        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        title.setText(note.getTitle());
        content.setText(note.getContent());
    }
}