package com.example.gallery;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView tvposition;
    ImageView ivlogo;
  public CardView cardView;
    // Constructor for ViewHolder
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        tvposition = itemView.findViewById(R.id.tvposition);
        ivlogo = itemView.findViewById(R.id.ivlogo);
        cardView = itemView.findViewById(R.id.main_container);
    }
}
