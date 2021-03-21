package com.example.notes;

import android.os.AsyncTask;

import java.util.List;

class SearchAllAsyncTask extends AsyncTask<Void,Void, List<Note>>{

    private NoteDao mNoteDao;

    public SearchAllAsyncTask( NoteDao noteDao)
    {
        this.mNoteDao = noteDao;
    }

    @Override
    protected List<Note> doInBackground(Void... voids) {
        return mNoteDao.displayAll() ;
    }
}
