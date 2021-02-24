package com.example.notes;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insert(@NonNull Note note);

    @Update
    public void update(@NonNull Note note);

    @Delete
    public void delete(@NonNull Note note);

    @Query("SELECT * FROM NoteTable ORDER by Title ASC")
    public List<Note> displayAll();

    @Query("SELECT * FROM NoteTable WHERE Title == :title ")
    public Note search(String title);

    @Query("DELETE FROM NoteTable")
    public void deleteAll();
}
