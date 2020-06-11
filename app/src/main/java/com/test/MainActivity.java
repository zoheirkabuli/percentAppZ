package com.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    EditText allNum;
    EditText correct;
    EditText incorrect;
    Button calculate;
    TextView result;
    double percentage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allNum = findViewById(R.id.editText_all);
        correct = findViewById(R.id.editText_correct);
        incorrect = findViewById(R.id.editText_incorrect);
        calculate = findViewById(R.id.cal_button);
        result = findViewById(R.id.textView_answer);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!allNum.getText().toString().isEmpty() && !correct.getText().toString().isEmpty() && !incorrect.getText().toString().isEmpty()) {
                    double all = Double.parseDouble(allNum.getText().toString());
                    double cor = Double.parseDouble(correct.getText().toString());
                    double incor = Double.parseDouble(incorrect.getText().toString());
                    if(all >= cor + incor) {
                        double percent = (((3 * cor) - incor) / (3 * all) * 100);
                        try {
                            result.setText(Double.toString(percent).concat("00").substring(0, 5) + "%");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        result.setText("inv");
                    }
                } else {
                    result.setText("inv");
                }
            }
        });
    }
}
