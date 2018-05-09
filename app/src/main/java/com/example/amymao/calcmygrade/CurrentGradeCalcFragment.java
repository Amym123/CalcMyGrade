package com.example.amymao.calcmygrade;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CurrentGradeCalcFragment extends Fragment {

    private List<Double> weightsList;
    private List<Double> gradesList;
    private List<Double[]> pairList;

    public static final String ARG_SECTION_NUMBER = "section_number";

    public CurrentGradeCalcFragment() {

        weightsList = new ArrayList<>();
        gradesList = new ArrayList<>();
        pairList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.current_grade_layout, container, false);

    }

    /**
     *
     * @return an ArrayList of Double Arrays of each pair of grades and weights
     */
    public List<Double[]> getInputs(View view) {

        int[] gradesArray = {R.id.Input1, R.id.Input2, R.id.Input3, R.id.Input4, R.id.Input5,
                R.id.Input6, R.id.Input7, R.id.Input8, R.id.Input9, R.id.Input10};
        int[] weightsArray = {R.id.Weight1, R.id.Weight2, R.id.Weight3, R.id.Weight4, R.id.Weight5,
                R.id.Weight6, R.id.Weight7, R.id.Weight8, R.id.Weight9, R.id.Weight10};

        // for each editText of grades, place them in the gradesList
        for(int gradeID: gradesArray) {
            EditText grade = view.findViewById(gradeID);
            String gradeString = grade.getText().toString();
            double gradePercent;
            if (!gradeString.trim().equals("")) {
                gradePercent = Double.parseDouble(gradeString);
            } else {
                gradePercent = 0.00;
            }
            gradesList.add(gradePercent);
        }

        // for each editText of Weights, place them in the WeightsList
        for (int weightID: weightsArray) {
            EditText weightText = view.findViewById(weightID);
            String weightString = weightText.getText().toString();
            double weight;
            if (!weightString.trim().equals("")) {
                weight = Double.parseDouble(weightString);
            } else {
                weight = 0.00;
            }
            weightsList.add(weight);
        }

        // fills in pairList with 10 pairs of (grades, weights)
        for (int i = 0; i < gradesList.size(); i++){
            Double[] pair = {gradesList.get(i), weightsList.get(i)};
            pairList.add(pair);
        }


        return pairList;
    }


    /**
     * send the calculated result to view on screen view TextView
     */
    public void calculateGrades() {
        CurrentCourseGradeCalculator calculator = new CurrentCourseGradeCalculator();
        Double[] calcResult = calculator.calculate(this.getInputs(getView()));

        DecimalFormat f = new DecimalFormat("###.##");
        f.format(calcResult[1]);
        f.format(calcResult[2]);
        TextView gradeReport = Objects.requireNonNull(getView()).findViewById(R.id.grade_report);
        gradeReport.setTextSize(11);
        gradeReport.setText("total weight: " + calcResult[0] + "%, Unscaled grade: " + calcResult[1]
                            + "%, Scaled grade: " + calcResult[2] + "%." );

    }
}
