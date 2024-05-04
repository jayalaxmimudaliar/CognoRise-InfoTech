package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView resultTv,solutionTv;
    MaterialButton buttonC,buttonOpen,buttonClose,bDivide,bMultiply,bMinus,bPlus,buttonEqual,buttonAC,buttonDot;
    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv=findViewById(R.id.result);
        solutionTv=findViewById(R.id.solution);
        assign(buttonC,R.id.clear);
        assign(buttonOpen,R.id.open_brac);
        assign(buttonClose,R.id.close_brac);
        assign(button0,R.id.button_0);
        assign(button1,R.id.button_1);
        assign(button2,R.id.button_2);
        assign(button3,R.id.button_3);
        assign(button4,R.id.button_4);
        assign(button5,R.id.button_5);
        assign(button6,R.id.button_6);
        assign(button7,R.id.button_7);
        assign(button8,R.id.button_8);
        assign(button9,R.id.button_9);
        assign(buttonEqual,R.id.button_equal);
        assign(buttonAC,R.id.all_clear);
        assign(buttonDot,R.id.button_dot);
        assign(bDivide,R.id.divide);
        assign(bMinus,R.id.minus);
        assign(bMultiply,R.id.multiply);
        assign(bPlus,R.id.plus);




    }

    public void assign(MaterialButton btn,int id)
    {
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        MaterialButton button=(MaterialButton) view;
        String textButton= button.getText().toString();
       String dataCalculate=solutionTv.getText().toString();

       if(textButton.equals("AC"))
       {
           try{
           solutionTv.setText("");

           resultTv.setText("0");
           return;
           }
           catch (Exception e)
           {
               return;
           }

       }
       if(textButton.equals("="))
       {
           solutionTv.setText(resultTv.getText());
           return;
       }
       if (textButton.equals("C")) {
           try {
               // Check if the calculation string is not empty before attempting to delete the last character
               if (!dataCalculate.isEmpty()) {
                   dataCalculate = dataCalculate.substring(0, dataCalculate.length() - 1);
               }
           } catch (Exception e) {
               // Log any exceptions that might occur during substring operation
               e.printStackTrace();
           }
       }
       else{
        dataCalculate=dataCalculate+textButton;}

       solutionTv.setText(dataCalculate);

       String f=result(dataCalculate.trim());


       if(!f.equals("err")){
       resultTv.setText(f);}

    }

    String result(String data)
    {
        try {
            Context context=Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable=context.initStandardObjects();
           String finalResult;//context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if (!data.isEmpty()) {
                finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            } else {
                finalResult = "0"; // Set a default value when the calculation string is empty
            }

           if(finalResult.endsWith(".0"))
           {
               finalResult=finalResult.replace(".0","");
           }
           return finalResult;
        }
        catch (Exception e)
        {
            return "err";
        }
    }
}