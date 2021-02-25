package com.example.notes;

import android.os.AsyncTask;

class SearchAsyncTask extends AsyncTask<Void,Void,Void> {

    private NoteDao mNoteDao;
    private String mtitle;
    private Note note;

    public Note getNote(NoteDao dao , String title)
    {
        this.mNoteDao =dao;
        this.mtitle = title;
        new SearchAsyncTask().execute();
        return note;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        note = mNoteDao.search(mtitle);
        return null;
    }
}
