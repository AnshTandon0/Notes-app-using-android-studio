package com.example.notes;

import android.os.AsyncTask;

class UpdateAsyncTask extends AsyncTask<Note,Void,Void> {

    private NoteDao mNoteDao;
    public UpdateAsyncTask(NoteDao dao) {
        mNoteDao = dao;
    }
    @Override
    protected Void doInBackground(Note... notes) {

        mNoteDao.update(notes[0]);
        return null;
    }
}
