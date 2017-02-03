package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 02.02.17.
 */
public class ParserTest {

    @Test
    public void deleteSpacesTest(){
        Parser p = new Parser();
        assertThat(p.deleteSpaces("He ll o"), is("Hello"));
    }
    @Test
    public void createSepArrayTest(){
        String text = "43+1/23*1.34";
        Parser p = new Parser();
        assertThat(p.createSepArray(text), is(Arrays.asList('+','/','*')));
    }
}