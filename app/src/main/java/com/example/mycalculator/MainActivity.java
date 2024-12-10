package com.example.mycalculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText numberOne;
    EditText numberTwo;
    TextView resultView;
    Button plusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOne = findViewById(R.id.numberOne);
        numberTwo = findViewById(R.id.numberTwo);
        plusButton = findViewById(R.id.button);
        resultView = findViewById(R.id.resultView);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText -> String -> number
                double num1 = Double.parseDouble(numberOne.getText().toString());
                double num2 = Double.parseDouble(numberTwo.getText().toString());
                if (!numberOne.getText().toString().isEmpty() && !numberOne.getText().toString().isEmpty()) {
                    double result = num1 + num2;
                    resultView.setText("Result: " + result);
                }
            }
        });

    }
}