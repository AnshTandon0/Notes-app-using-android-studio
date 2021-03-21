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
    private ItemClickListener itemClickListener;

    public NoteListAdapter(List<Note> notes, Context context , ItemClickListener itemClickListener) {
        allNotes = notes;
        this.layoutInflater = layoutInflater.from(context);
        this.itemClickListener = itemClickListener;
    }


    public class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView textView;
        private ItemClickListener itemClickListener;
        public NoteViewHolder( View itemView , ItemClickListener itemClickListener) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.title);
            this.itemClickListener = itemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = layoutInflater.inflate(R.layout.note,parent,false);
        return new NoteViewHolder(mView , itemClickListener );
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        if (allNotes != null) {
            holder.textView.setText(allNotes.get(position).getTitle());
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

    public interface ItemClickListener
    {
        void onItemClick( int position);
    }
}
