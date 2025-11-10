package com.example.banco;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.banco.model.Account;
import com.example.banco.model.DomainException;

public class MainActivity extends AppCompatActivity {

    EditText idNumber, idHolder, idBalance, idLimit, idAmount;
    TextView txtResult;

    Account conta;

    @SuppressLint("MissingInflatedId")
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
        idAmount = findViewById(R.id.idAmount);

        txtResult = findViewById(R.id.idResult);
        
    }

    public void button(View view) {
        try {
            int number = safeParseInt(idNumber.getText().toString());
            String holder = idHolder.getText().toString();
            double balance = safeParseDouble(idBalance.getText().toString());
            double limit = safeParseDouble(idLimit.getText().toString());
            double amount = safeParseDouble(idAmount.getText().toString());

            conta = new Account(number, holder, balance, limit);

            conta.withdraw(amount);
            txtResult.setText(conta.getBalance());
        } catch (DomainException e){
            txtResult.setText("Withdraw error: " + e.getMessage());
        } catch (RuntimeException e){
            txtResult.setText("Unexpectded error:");
        }
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