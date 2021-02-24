package com.example.notes;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class},version = 1,exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase db;
    public abstract NoteDao noteDao() ;
    public static NoteDatabase getInstance(Context context)
    {
        if (db==null)
        {
           db =  db.buildDatabaseInstance(context);
        }
    return db;
    }
    private static NoteDatabase buildDatabaseInstance(Context context)
    {
    return Room.databaseBuilder(context,NoteDatabase.class,"db_name")
            .allowMainThreadQueries()
            .build();
    }

    public void cleanUp()
    {
        db = null;
    }

}
