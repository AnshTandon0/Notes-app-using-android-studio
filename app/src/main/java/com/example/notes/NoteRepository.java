package com.example.notes;

import android.content.Context;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class NoteRepository {

    private NoteDao noteDao;

    public NoteRepository(Context context)
    {
        NoteDatabase noteDatabase = NoteDatabase.getInstance(context);
        noteDao = noteDatabase.noteDao();
    }

    public List<Note> getAllNotes() throws ExecutionException, InterruptedException {
        return new SearchAllAsyncTask(noteDao).execute().get();
    }
    public Note search (String title) throws ExecutionException, InterruptedException {
        return new SearchAsyncTask(noteDao).execute(title).get();
    }
    public void deleteAll() {new DeleteAllAsyncTask(noteDao).execute();}
    public void insert (Note note)
    {
       new InsertAsyncTask(noteDao).execute(note);
    }
    public void update (Note note)
    {
        new UpdateAsyncTask(noteDao).execute(note);
    }
    public void delete (Note note)
    {
        new DeleteAsyncTask(noteDao).execute(note);
    }
}
