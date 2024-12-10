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
    Button equalsButton, plusButton, minusButton, multiplyButton, divideButton;

    // Store the selected operation
    String selectedOperation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        numberOne = findViewById(R.id.numberOne);
        numberTwo = findViewById(R.id.numberTwo);
        resultView = findViewById(R.id.resultView);

        equalsButton = findViewById(R.id.equalsButton);
        plusButton = findViewById(R.id.plusButton);
        minusButton = findViewById(R.id.minusButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);

        // Set click listeners for operator buttons
        plusButton.setOnClickListener(v -> selectedOperation = "+");
        minusButton.setOnClickListener(v -> selectedOperation = "-");
        multiplyButton.setOnClickListener(v -> selectedOperation = "*");
        divideButton.setOnClickListener(v -> selectedOperation = "/");

        // Set click listener for equals button
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input as strings
                String num1String = numberOne.getText().toString();
                String num2String = numberTwo.getText().toString();

                // Check for empty input
                if (!num1String.isEmpty() && !num2String.isEmpty()) {
                    try {
                        // Parse the input strings to numbers
                        double num1 = Double.parseDouble(num1String);
                        double num2 = Double.parseDouble(num2String);

                        // Perform the operation based on the selected operator
                        double result = 0;
                        switch (selectedOperation) {
                            case "+":
                                result = num1 + num2;
                                break;
                            case "-":
                                result = num1 - num2;
                                break;
                            case "*":
                                result = num1 * num2;
                                break;
                            case "/":
                                if (num2 != 0) {
                                    result = num1 / num2;
                                } else {
                                    resultView.setText("Divide yourself by zero, Simon!");
                                    return;
                                }
                                break;
                            default:
                                resultView.setText("That's not how the life is, Simon!");
                                return;
                        }

                        // Display the result
                        resultView.setText(getString(R.string.result_text, result));

                    } catch (NumberFormatException e) {
                        resultView.setText("Please enter real numbers, Simon!");
                    }
                } else {
                    resultView.setText("Please enter both numbers, Simon!");
                }
            }
        });
    }
}
