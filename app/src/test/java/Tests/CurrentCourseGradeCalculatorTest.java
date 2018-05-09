package Tests;

import com.example.amymao.calcmygrade.CurrentCourseGradeCalculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class CurrentCourseGradeCalculatorTest {
    CurrentCourseGradeCalculator calculator;

    List<Double[]> pairsA = new ArrayList<>();
    List<Double[]> pairsB = new ArrayList<>();

    @Before
    public void Before(){
        calculator = new CurrentCourseGradeCalculator();


        // total: 100% in weight
        Double[] pair1a = {100.0, 20.0};
        Double[] pair2a = {90.0, 10.0};
        Double[] pair3a = {80.0, 10.0};
        Double[] pair4a = {70.0, 15.0};
        Double[] pair5a = {100.0, 45.0};
        Double[] pair6a = {0.0, 0.0};
        Double[] pair7a = {0.0, 0.0};
        Double[] pair8a = {0.0, 0.0};
        Double[] pair9a = {0.0, 0.0};
        Double[] pair10a = {0.0, 0.0};
        pairsA.add(pair1a);
        pairsA.add(pair2a);
        pairsA.add(pair3a);
        pairsA.add(pair4a);
        pairsA.add(pair5a);
        pairsA.add(pair6a);
        pairsA.add(pair7a);
        pairsA.add(pair8a);
        pairsA.add(pair9a);
        pairsA.add(pair10a);



        //total: 75% in weight
        Double[] pair1b = {100.0, 20.0};
        Double[] pair2b = {90.0, 10.0};
        Double[] pair3b = {80.0, 10.0};
        Double[] pair4b = {70.0, 15.0};
        Double[] pair5b = {100.0, 20.0};
        Double[] pair6b = {0.0, 0.0};
        Double[] pair7b = {0.0, 0.0};
        Double[] pair8b = {0.0, 0.0};
        Double[] pair9b = {0.0, 0.0};
        Double[] pair10b = {0.0, 0.0};
        pairsB.add(pair1b);
        pairsB.add(pair2b);
        pairsB.add(pair3b);
        pairsB.add(pair4b);
        pairsB.add(pair5b);
        pairsB.add(pair6b);
        pairsB.add(pair7b);
        pairsB.add(pair8b);
        pairsB.add(pair9b);
        pairsB.add(pair10b);


    }




    @Test
    public void testUnscaledGrade(){
        Double[] result = calculator.calculate(pairsA);
        assertEquals(92.5, result[1], 0);

        Double[] result2 = calculator.calculate(pairsB);
        assertEquals(67.5, result2[1], 0);
    }

    @Test
    public void testScaledGrade(){
        Double[] result = calculator.calculate(pairsA);
        assertEquals(92.5, result[2], 0);

        Double[] result2 = calculator.calculate(pairsB);
        assertEquals(90.0, result2[2], 0);
    }

    //TODO: add case when input is over 100%
}
