package com.example.bmi_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        @SuppressLint("MissingInflatedId") Button b= findViewById(R.id.calc);
        EditText w=findViewById(R.id.weight);
        EditText h=findViewById(R.id.height);
        TextView calculateTv=findViewById(R.id.bmi_num);
        TextView resultTv=findViewById(R.id.bmi_str);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float stWeight= Float.parseFloat(String.valueOf( w.getText()));
                float stHeight= Float.parseFloat(String.valueOf( h.getText()));
                float bmi=stWeight/(stHeight*stHeight);

                calculateTv.setText(String.valueOf(bmi));

                if(bmi<18.5)
                {
                    resultTv.setText("Underweight!!" );
                }
                else if (bmi>18.5 && bmi<24.9) {
                    resultTv.setText("Healthy!!" );
                }
                else if (bmi>25.0 && bmi<29.9) {
                    resultTv.setText("Overweight!!" );
                }
                else if (bmi>30.0) {
                    resultTv.setText("Obesity!!" );

                }
            }
        });



    }
}