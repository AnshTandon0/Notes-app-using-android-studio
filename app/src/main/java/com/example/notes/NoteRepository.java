package com.example.notes;

import android.content.Context;

import java.util.List;

public class NoteRepository {

    private List<Note> allNotes;
    private NoteDao noteDao;

    public NoteRepository(Context context)
    {
        NoteDatabase noteDatabase = NoteDatabase.getInstance(context);
        noteDao = noteDatabase.noteDao();
        allNotes = noteDao.displayAll();
    }

    public List<Note> getAllNotes()
    {
        return allNotes;
    }

    public void insert (Note note)
    {
       new InsertAsyncTask(noteDao).execute(note);
    }
    public Note search (String title)
    {
        return noteDao.search(title);
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
