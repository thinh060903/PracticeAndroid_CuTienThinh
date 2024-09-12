package com.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtGreeting;
    private Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // B1: Tham chieu BIEN tai phan tu GIAO DIEN
        txtGreeting = (TextView) findViewById(R.id.txtGreeting);
        btnClick = (Button) findViewById(R.id.btnClick);

        // B2: Bat su kien Click
        btnClick.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {
        Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle myObject = new Bundle();
        myObject.putString("data", "Xin chào Second");
        myIntent.putExtra("myobj", myObject);
        startActivity(myIntent);
    }
}