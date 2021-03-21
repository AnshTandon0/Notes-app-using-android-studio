package com.example.notes;

import android.os.AsyncTask;

class SearchAsyncTask extends AsyncTask<String,Void,Note> {

    private NoteDao mNoteDao;

    public SearchAsyncTask( NoteDao noteDao)
    {
        this.mNoteDao = noteDao;
    }

    @Override
    protected Note doInBackground(String... strings) {
        return mNoteDao.search(strings[0]);
    }
}
