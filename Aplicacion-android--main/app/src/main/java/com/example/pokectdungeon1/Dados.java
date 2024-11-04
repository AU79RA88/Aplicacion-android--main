package com.example.pokectdungeon1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class Dados extends AppCompatActivity {

    private ImageView diceImageView;
    private TextView destinationTextView;
    private TextView texdbTextView;
    private Random random = new Random();
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        diceImageView = findViewById(R.id.imageView3);
        destinationTextView = findViewById(R.id.textView);
        texdbTextView = findViewById(R.id.texdb);
        ImageButton rollButton = findViewById(R.id.imageButton5);
        ImageButton backButton = findViewById(R.id.imageButton6);

        databaseHelper = new DatabaseHelper(this);

        rollButton.setOnClickListener(v -> {
            int diceRoll = random.nextInt(20) + 1;
            int diceImageResId = getResources().getIdentifier("dado" + diceRoll, "drawable", getPackageName());
            diceImageView.setImageResource(diceImageResId);

            String destination = "Tu destino es: " + diceRoll;
            destinationTextView.setText(destination);

            // Obtener y mostrar el mensaje desde la base de datos
            String message = databaseHelper.getMessage(diceRoll);
            texdbTextView.setText(message);
        });

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(Dados.this, Paginapj.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (databaseHelper != null) {
            databaseHelper.close();
        }
    }
}
