package com.example.notes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "NoteTable")
public class Note {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "Title")
    private String title;

    @NonNull
    @ColumnInfo(name = "Content")
    private String content;
}
