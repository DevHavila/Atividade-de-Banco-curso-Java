package com.example.banco;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.banco.model.Account;

public class MainActivity extends AppCompatActivity {

    EditText idNumber, idHolder, idBalance, idLimit, idSaque;

    Account conta;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idNumber = findViewById(R.id.idNumber);
        idHolder = findViewById(R.id.idHolder);
        idBalance = findViewById(R.id.idBalance);
        idLimit = findViewById(R.id.idLimit);

        int number = safeParseInt(idNumber.getText().toString());
        String holder = idHolder.getText().toString();
        double balance = safeParseDouble(idBalance.getText().toString());
        double limit = safeParseDouble(idLimit.getText().toString());

        Account conta = new Account(number, holder, balance, limit);

    }

    private int safeParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private double safeParseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}