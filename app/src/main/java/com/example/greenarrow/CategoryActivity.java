package com.example.greenarrow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.greenarrow.res_mvc.StringConstants.FOOD_TEST_KEY;
import static com.example.greenarrow.res_mvc.StringConstants.LIFESTYLE_TEST_KEY;
import static com.example.greenarrow.res_mvc.StringConstants.SHOPPING_TEST_KEY;
import static com.example.greenarrow.res_mvc.StringConstants.TRAVELLING_TEST_KEY;

public class CategoryActivity extends AppCompatActivity {

    Button categoryLifestyle;
    Button categoryShopping;
    Button categoryFood;
    Button categoryTravelling;

    private View.OnClickListener mOnLifestyleClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CategoryActivity.this, ExpressTestActivity.class);
            intent.putExtra("key", LIFESTYLE_TEST_KEY);
            startActivity(intent);
            finishAffinity();
        }
    };
    private View.OnClickListener mOnShoppingClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CategoryActivity.this, ExpressTestActivity.class);
            intent.putExtra("key", SHOPPING_TEST_KEY);
            startActivity(intent);
            finishAffinity();
        }
    };
    private View.OnClickListener mOnFoodClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CategoryActivity.this, ExpressTestActivity.class);
            intent.putExtra("key", FOOD_TEST_KEY);
            startActivity(intent);
            finishAffinity();
        }
    };
    private View.OnClickListener mOnTravellingClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CategoryActivity.this, ExpressTestActivity.class);
            intent.putExtra("key", TRAVELLING_TEST_KEY);
            startActivity(intent);
            finishAffinity();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        categoryLifestyle = findViewById(R.id.category_lifestyle);
        categoryShopping = findViewById(R.id.category_shopping);
        categoryFood = findViewById(R.id.category_food);
        categoryTravelling = findViewById(R.id.category_travelling);

        categoryLifestyle.setOnClickListener(mOnLifestyleClickListener);
        categoryShopping.setOnClickListener(mOnShoppingClickListener);
        categoryFood.setOnClickListener(mOnFoodClickListener);
        categoryTravelling.setOnClickListener(mOnTravellingClickListener);
    }

    //TODO: activity logic
}