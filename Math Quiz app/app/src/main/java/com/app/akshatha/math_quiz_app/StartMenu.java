package com.app.akshatha.math_quiz_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StartMenu extends AppCompatActivity {
    String operand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);
        Button add = (Button)findViewById(R.id.add);
        Button sub = (Button)findViewById(R.id.sub);
        Button prod = (Button)findViewById(R.id.mul);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operand = "+";
                Intent intent = new Intent(StartMenu.this,QuizActivity.class);
                intent.putExtra("operand", operand);
                startActivity(intent);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operand = "-";
                Intent intent = new Intent(StartMenu.this,QuizActivity.class);
                intent.putExtra("operand", operand);
                startActivity(intent);
            }
        });
        prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operand = "*";
                Intent intent = new Intent(StartMenu.this,QuizActivity.class);
                intent.putExtra("operand", operand);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
