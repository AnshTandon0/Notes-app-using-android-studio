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

    public Note(@NonNull String title, @NonNull String content) {
        this.title = title;
        this.content = content;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getContent() {
        return content;
    }

    public void setContent(@NonNull String content) {
        this.content = content;
    }
}
