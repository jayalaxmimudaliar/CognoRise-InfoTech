package com.example.to_do_list;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button add;
    AlertDialog dialog;
    LinearLayout layout;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add=findViewById(R.id.add);
        layout=findViewById(R.id.container);

        buildDailog();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }
    public void buildDailog()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        View view=getLayoutInflater().inflate(R.layout.dialog,null);
        @SuppressLint("MissingInflatedId") EditText name=view.findViewById(R.id.nameEdit);
        builder.setView(view);
        builder.setTitle("Enter the Task")
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        addCard(name.getText().toString());
                        name.setText("");
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        dialog=builder.create();


    }
    private void addCard(String name)
    {
        View nview=getLayoutInflater().inflate(R.layout.card,null);
        @SuppressLint("MissingInflatedId") TextView tname=nview.findViewById(R.id.name);
        tname.setText(name);

        @SuppressLint("MissingInflatedId") Button delete=nview.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.removeView(nview);
            }
        });
        layout.addView(nview);
    }
}