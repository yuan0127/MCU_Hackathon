package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2 extends AppCompatActivity {
    private Spinner Society;
    private DatabaseReference mDatabase;
    String[] Societies=new String[]{mDatabase};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_2);

        Society=(Spinner) findViewById(R.id.Society);
        Button btnback = (Button) findViewById(R.id.btnback);

        ArrayAdapter<String>adapterSocieties=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Societies);
        adapterSocieties.setAdapter(adapterSocieties);
        mDatabase = FirebaseDatabase.getInstance().getReference();


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main2.this, MainActivity.class);
                startActivity(intent);
            }
        });}
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
