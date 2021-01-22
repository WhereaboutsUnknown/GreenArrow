package com.example.greenarrow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.greenarrow.res_mvc.StringConstants.EXAM_KEY;

public class ExamActivity extends AppCompatActivity {

    Button startExam;

    private View.OnClickListener mOnButtonStartExamClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ExamActivity.this, ExpressTestActivity.class);
            intent.putExtra("key", EXAM_KEY);
            startActivity(intent);
            finishAffinity();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        startExam = findViewById(R.id.start_exam);

        startExam.setOnClickListener(mOnButtonStartExamClickListener);
    }

    //TODO: activity logic, fragments
}