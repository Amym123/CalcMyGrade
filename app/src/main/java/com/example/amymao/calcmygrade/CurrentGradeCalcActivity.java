



package com.example.amymao.calcmygrade;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;

import java.util.ArrayList;

public class CurrentGradeCalcActivity extends FragmentActivity {

    private Button addWeight;
    /*for CurrentGradeCalcActivity: can enter arbitrary fields.
     */
//    private ArrayList<String> listItems = new ArrayList<>();
//    ArrayAdapter<String> adapter;
//    int clickCounter = 0;


    private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

    public CurrentGradeCalcFragment fragment;
    public static int GRADE_POSITION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_grade_calc);


        fragment = new CurrentGradeCalcFragment();
        Bundle args = new Bundle();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.commit();

        addWeight = findViewById(R.id.addWeightBtn);



    }




    public void showNextRow(View view) {
        View v = findViewById(R.id.final_grade_table);
        GRADE_POSITION += 1;
        if (GRADE_POSITION == 2) {
            TableRow row = v.findViewById(R.id.grade2);
            row.setVisibility(View.VISIBLE);
        } else if (GRADE_POSITION == 3) {
            TableRow row = v.findViewById(R.id.grade3);
            row.setVisibility(View.VISIBLE);
        } else if (GRADE_POSITION == 4) {
            TableRow row = v.findViewById(R.id.grade4);
            row.setVisibility(View.VISIBLE);
        } else if (GRADE_POSITION == 5) {
            TableRow row = v.findViewById(R.id.grade5);
            row.setVisibility(View.VISIBLE);
        } else if (GRADE_POSITION == 6) {
            TableRow row = v.findViewById(R.id.grade6);
            row.setVisibility(View.VISIBLE);
        } else if (GRADE_POSITION == 7) {
            TableRow row = v.findViewById(R.id.grade7);
            row.setVisibility(View.VISIBLE);
        } else if (GRADE_POSITION == 8) {
            TableRow row = v.findViewById(R.id.grade8);
            row.setVisibility(View.VISIBLE);
        } else if (GRADE_POSITION == 9) {
            TableRow row = v.findViewById(R.id.grade9);
            row.setVisibility(View.VISIBLE);
        } else if (GRADE_POSITION == 10) {
            TableRow row = v.findViewById(R.id.grade10);
            row.setVisibility(View.VISIBLE);
        }

    }




    public void calculateGrade(View view) {

        fragment.calculateGrades();
    }


}

