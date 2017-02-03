package com.company;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 02.02.17.
 */
public class CalcTest {

    @Test
    public void additionTest(){
        String text = "5+6";
        Calc calc = new Calc();
        assertThat(calc.evaluate(text), is(11.0));
    }

    @Test
    public void complexAdditionTest(){
        String text = "(5+6)*10";
        Calc calc = new Calc();
        assertThat(calc.evaluate(text), is(110.0));
    }

}