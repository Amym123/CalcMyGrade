package com.example.amymao.calcmygrade;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class CurrentGradeCalcActivity extends ListActivity {

    private Button addWeight;
    /*for CurrentGradeCalcActivity: can enter arbitrary fields.
   */
    private ArrayList<String> listItems = new ArrayList<>();
    ArrayAdapter<String> adapter;
    int clickCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_grade_calc);


        addWeight = findViewById(R.id.addWeightBtn);
        addWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        setListAdapter(adapter);
    }


    public void addItems(View v) {
        listItems.add("Clicked : "+clickCounter++);
        adapter.notifyDataSetChanged();
    }
}
