package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddNote extends AppCompatActivity {

    EditText title;
    EditText content;
    NoteRepository noteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        noteRepository = new NoteRepository(AddNote.this);
    }
    public void addNote(View view)
    {
        noteRepository.insert(new Note(title.getText().toString(),content.getText().toString()));
        Intent intent = new Intent(AddNote.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}