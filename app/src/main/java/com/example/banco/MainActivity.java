package com.example.banco;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.banco.model.Account;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Account conta = new Account(number, holder, balance, limit);

        
    }

    public Object TPV(TextView tpv) {
        String text = tpv.toString();

        if (text.matches("-?\\d+")) {
            return Integer.parseInt(text);
        } else if (text.matches("-?\\d*\\.\\d+")) {
            return Double.parseDouble(text);
        } else {
            return text; // retorna String
        }
    }
    
}