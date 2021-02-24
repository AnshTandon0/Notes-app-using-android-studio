package com.example.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter <NoteListAdapter.NoteViewHolder> {

    private final List<Note> allNotes;
    private LayoutInflater layoutInflater;

    public NoteListAdapter(List<Note> notes, Context context) {
        allNotes = notes;
        this.layoutInflater = layoutInflater.from(context);
    }


    public class NoteViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textView;
        public NoteViewHolder(View itemView , NoteListAdapter noteListAdapter) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
        }
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = layoutInflater.inflate(R.layout.note,parent,false);
        return new NoteViewHolder(mView , this);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        if (allNotes != null) {
            Note note = allNotes.get(position);
            String mCurrent = note.getTitle();
            holder.textView.setText(mCurrent);
        }
        else
        {
            holder.textView.setText("No Notes");
        }
    }

    @Override
    public int getItemCount() {
        if (allNotes!=null)
            return allNotes.size();
        return 0;
    }

}
