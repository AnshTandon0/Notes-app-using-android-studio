package com.example.notes;

import android.content.Context;
import android.os.AsyncTask;
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
       new insertAsyncTask(noteDao).execute(note);
    }
    public Note search (String title)
    {
        return noteDao.search(title);
    }

    private static class insertAsyncTask extends AsyncTask<Note,Void,Void>
    {
        private NoteDao mNoteDao;
        public insertAsyncTask(NoteDao dao) {
            mNoteDao = dao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mNoteDao.insert(notes[0]);
            return null;
        }
    }

}
