package com.pratik.emical;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText amount,interest,month;

    Button calculate;

    TextView Emi,txtAmount,txtInterest;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.amount);
        interest = findViewById(R.id.interest);
        month = findViewById(R.id.month);
        calculate = findViewById(R.id.calculate);
        Emi = findViewById(R.id.Emi);
        txtAmount = findViewById(R.id.txtAmount);
        txtInterest = findViewById(R.id.txtInterest);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int amt = Integer.parseInt(amount.getText().toString());
                double rest = Double.parseDouble(interest.getText().toString());
                int mon = Integer.parseInt(month.getText().toString());

                double r = rest/(12*100);
                double calculate = 1;
                for (int i = 0; i < mon; i++) {

                    calculate *= (1+r);
                }

                double ans = amt * r* (calculate/(calculate-1));
                Emi.setText("Emi = "+ans);
                double total = ans*mon;
                txtAmount.setText("Total AMount ="+total);
                double MyAmt = total-amt;
                txtInterest.setText("Interest Amount ="+MyAmt);
            }
        });
    }
}