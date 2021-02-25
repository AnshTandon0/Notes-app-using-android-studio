package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

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
}