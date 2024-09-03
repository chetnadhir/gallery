package com.example.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FullScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_full_screen);


        ImageView imageView = findViewById(R.id.full_screen_image);

        Intent intent = getIntent();
        int imageResId = intent.getIntExtra("IMAGE_RES_ID", -1);
        if (imageResId != -1) {
            imageView.setImageResource(imageResId);
        }
    }
}