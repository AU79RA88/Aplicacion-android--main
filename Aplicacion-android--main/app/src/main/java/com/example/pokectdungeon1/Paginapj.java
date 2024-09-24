package com.example.pokectdungeon1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Paginapj extends AppCompatActivity {

    private ImageView characterImageView;
    private int[] characterImages = {R.drawable.pj_caballero, R.drawable.pj_asesino};
    private int currentCharacterIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_paginapj);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        characterImageView = findViewById(R.id.imageView);
        ImageButton nextButton = findViewById(R.id.imageButton2);
        ImageButton prevButton = findViewById(R.id.imageButton3);
        ImageButton goButton = findViewById(R.id.imageButton4);

        nextButton.setOnClickListener(v -> {
            currentCharacterIndex = (currentCharacterIndex + 1) % characterImages.length;
            characterImageView.setImageResource(characterImages[currentCharacterIndex]);
        });

        prevButton.setOnClickListener(v -> {
            currentCharacterIndex = (currentCharacterIndex - 1 + characterImages.length) % characterImages.length;
            characterImageView.setImageResource(characterImages[currentCharacterIndex]);
        });

        goButton.setOnClickListener(v -> {
            Intent intent = new Intent(Paginapj.this, Dados.class);
            intent.putExtra("characterImage", characterImages[currentCharacterIndex]);
            startActivity(intent);
        });
    }
}

