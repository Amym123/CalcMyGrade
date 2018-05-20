package com.example.amymao.calcmygrade;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button CurrentGradeCalc;
    private Button addGradebtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CurrentGradeCalc calculates what your current grade is given the weights. It directs to another page
        CurrentGradeCalc = findViewById(R.id.btnCalcCurrentGrade);
        //when user clicks on button, direct to another page for input weights
        CurrentGradeCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCurrentGradeCalcActivity();

            }
        });

        addGradebtn = findViewById(R.id.btnAddGrade);
        addGradebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public void openCurrentGradeCalcActivity(){
        Intent intent = new Intent(this, CurrentGradeCalcActivity.class);
        startActivity(intent);
    }



}
