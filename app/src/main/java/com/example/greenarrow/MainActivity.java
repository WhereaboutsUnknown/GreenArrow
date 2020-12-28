package com.example.greenarrow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button expressTest;
    Button categoryTest;
    Button examTest;
    Button progressScreen;

    private View.OnClickListener mOnExpressTestClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ExpressTestActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener mOnCategoryTestClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener mOnExamTestClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ExamActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener mOnProgressScreenClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ProgressActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expressTest = findViewById(R.id.express);
        categoryTest = findViewById(R.id.category);
        examTest = findViewById(R.id.exam);
        progressScreen = findViewById(R.id.progress);

        expressTest.setOnClickListener(mOnExpressTestClickListener);
        categoryTest.setOnClickListener(mOnCategoryTestClickListener);
        examTest.setOnClickListener(mOnExamTestClickListener);
        progressScreen.setOnClickListener(mOnProgressScreenClickListener);
    }


}