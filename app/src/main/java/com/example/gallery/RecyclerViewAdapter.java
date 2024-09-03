package com.example.gallery;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Data[] listdata;
    private ClickListener listener;

    public RecyclerViewAdapter(Data[] listdata, ClickListener listener) {
        this.listdata = listdata;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.cardview, parent, false); // Updated layout name
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (listdata == null || position < 0 || position >= listdata.length) {
            Log.e("RecyclerViewAdapter", "Invalid data or position");
            return;
        }

        final Data myListData = listdata[position];
        if (myListData == null) {
            Log.e("RecyclerViewAdapter", "Data item is null at position " + position);
            return;
        }

        holder.textView.setText(myListData.getTitle());

        int imageResId = myListData.getImg();
        try {
            if (imageResId != 0) {
                holder.imageView.setImageResource(imageResId);
            } else {
                holder.imageView.setImageResource(R.drawable.loid); // placeholder
            }
        } catch (Exception e) {
            Log.e("RecyclerViewAdapter", "Error setting image", e);
        }

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(position);
            } else {
                Log.e("RecyclerViewAdapter", "ClickListener is null");
            }
        });
    }




    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.tvposition);
            this.imageView = itemView.findViewById(R.id.ivlogo);
        }
    }

    public interface ClickListener {
        void onItemClick(int position);
    }
}
