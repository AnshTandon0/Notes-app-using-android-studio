package com.example.notes;

import android.os.AsyncTask;

public class DeleteAsyncTask extends AsyncTask<Note,Void,Void>
{

    private NoteDao mNoteDao;
    public DeleteAsyncTask(NoteDao dao) {
        mNoteDao = dao;
    }
    @Override
    protected Void doInBackground(Note... notes) {
        mNoteDao.delete(notes[0]);
        return null;
    }
}
