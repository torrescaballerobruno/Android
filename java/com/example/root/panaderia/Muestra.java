package com.example.root.panaderia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Muestra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muestra);
    }

    public void salir(View view){
        finish();
    }
}
