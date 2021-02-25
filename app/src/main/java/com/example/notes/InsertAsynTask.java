package com.example.notes;

import android.os.AsyncTask;

class InsertAsyncTask extends AsyncTask<Note,Void,Void>
{
    private NoteDao mNoteDao;
    public InsertAsyncTask(NoteDao dao) {
        mNoteDao = dao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        mNoteDao.insert(notes[0]);
        return null;
    }
}
