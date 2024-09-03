package com.example.gallery;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickListener {

    RecyclerView recyclerView;
    private Data[] myListData; // Class-level variable

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvitems);

        // Initialize the class-level myListData variable
        myListData = new Data[]{
                new Data("Tanjiro", R.drawable.tanjiro),
                new Data("Kanroji", R.drawable.kanroji),
                new Data("Loid", R.drawable.loid),
                new Data("peachy", R.drawable.peachy),
                new Data("Anya", R.drawable.anya),
                new Data("Naruto", R.drawable.naruto),



        };

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(myListData, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 6));
        recyclerView.setAdapter(recyclerViewAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onItemClick(int position) {

        if (position >= 0 && position < myListData.length) {
            Data clickedItem = myListData[position];
            Intent intent = new Intent(this, FullScreen.class);
            intent.putExtra("IMAGE_RES_ID", clickedItem.getImg());
            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid position: " + position, Toast.LENGTH_SHORT).show();
        }
    }
}
