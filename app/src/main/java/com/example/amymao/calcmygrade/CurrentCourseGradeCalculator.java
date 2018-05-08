package com.example.amymao.calcmygrade;

import java.util.List;

// CurrentCourseGradeCalculator calculate the grade of course entered in current grade activity
public class CurrentCourseGradeCalculator {

    public CurrentCourseGradeCalculator(){

    }

    /**
     *
     * @param gradeWeightPair list of (grade, weight) pairs found in input
     * @return {total weights entered, current grade out of 100, current grade so far with inputted grades (out of total weights)}
     */
    public Double[] calculate(List<Double[]> gradeWeightPair){

        double sumOfWeights = 0;
        double sumOfGradesUnscaled = 0;
        double multiplier;
        double sumOfGradesScaled = 0;


        for(Double[] pair: gradeWeightPair){
            sumOfWeights = sumOfWeights + pair[1];
            sumOfGradesUnscaled += pair[0]*pair[1]*0.01;
        }

        //if the grades entered don't add up to 100%, add result to return Array
        if (sumOfWeights < 100){
            multiplier = 100 / sumOfWeights;
            sumOfGradesScaled = sumOfGradesUnscaled * multiplier;
        }

        if (sumOfWeights == 100){
            sumOfGradesScaled = sumOfGradesUnscaled;
        }

        if (sumOfWeights > 100){
            // TODO: throw exception for error message
        }

        Double[] returnArray = {sumOfWeights, sumOfGradesUnscaled, sumOfGradesScaled};

        return returnArray;
    }

}
