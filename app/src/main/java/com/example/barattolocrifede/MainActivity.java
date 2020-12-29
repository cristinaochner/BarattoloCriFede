package com.example.barattolocrifede;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnMC, btnPC, btnMF, btnPF;
    EditText editPagC, editDebC, editPagF, editDebF;
    SharedPreferences sharedPreferences;

    int debF = 0, pagF = 0, debC = 0, pagC = 0;

    private void updateText() {
        editDebC.setText(String.valueOf(debC));
        editPagC.setText(String.valueOf(pagC));
        editDebF.setText(String.valueOf(debF));
        editPagF.setText(String.valueOf(pagF));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("debF", debF);
        editor.putInt("debC", debC);
        editor.putInt("pagF", pagF);
        editor.putInt("pagC", pagC);
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("Setting", Context.MODE_PRIVATE);
        debF = sharedPreferences.getInt("debF", 0);
        debC = sharedPreferences.getInt("debC", 0);
        pagF = sharedPreferences.getInt("pagF", 0);
        pagC = sharedPreferences.getInt("pagC", 0);

        btnMC = findViewById(R.id.btnMC);
        btnPC = findViewById(R.id.btnPC);
        btnMF = findViewById(R.id.btnMF);
        btnPF = findViewById(R.id.btnPF);
        editPagC = findViewById(R.id.editPagC);
        editPagF = findViewById(R.id.editPagF);
        editDebC = findViewById(R.id.editDebC);
        editDebF = findViewById(R.id.editDebF);

        updateText();

        btnMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                debC--;
                pagC++;

                updateText();
            }
        });
        btnPC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                debC++;
                updateText();
            }
        });
        btnMF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                debF--;
                pagF++;
                updateText();
            }
        });
        btnPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                debF++;
                updateText();
            }
        });
    }

}