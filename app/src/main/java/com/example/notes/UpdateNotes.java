package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateNotes extends AppCompatActivity {

    EditText content;
    NoteRepository noteRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_notes);
        content = findViewById(R.id.content);
        content.setText(getIntent().getStringExtra("content"));
        noteRepository = new NoteRepository(UpdateNotes.this);
    }

    public void update(View view)
    {
        noteRepository.update(new Note(getIntent().getStringExtra("title"),content.getText().toString()));
        Intent intent = new Intent(UpdateNotes.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}