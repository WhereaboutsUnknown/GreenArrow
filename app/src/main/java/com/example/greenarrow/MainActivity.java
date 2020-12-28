package com.example.greenarrow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button expressTest;
    Button categoryTest;
    Button examTest;

    private View.OnClickListener mOnExpressTestClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //TODO: starts new activity managing test card fragments
        }
    };
    private View.OnClickListener mOnCategoryTestClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //TODO: starts new activity that allows choosing category
        }
    };
    private View.OnClickListener mOnExamTestClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //TODO: starts new activity managing test card fragments
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expressTest = findViewById(R.id.express);
        categoryTest = findViewById(R.id.category);
        examTest = findViewById(R.id.exam);

        expressTest.setOnClickListener(mOnExpressTestClickListener);
        categoryTest.setOnClickListener(mOnCategoryTestClickListener);
        examTest.setOnClickListener(mOnExamTestClickListener);
    }


}