package com.example.notes;

import android.os.AsyncTask;

public class DeleteAllAsyncTask extends AsyncTask<Void,Void,Void>
{

    private NoteDao mNoteDao;
    public DeleteAllAsyncTask(NoteDao dao) {
        mNoteDao = dao;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        mNoteDao.deleteAll();
        return null;
    }
}
