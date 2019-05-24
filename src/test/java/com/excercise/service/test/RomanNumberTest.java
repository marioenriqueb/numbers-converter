package com.excercise.service.test;

import com.excercise.BaseTest;
import com.exercise.service.utils.RomanNumber;
import org.junit.Assert;
import org.junit.Test;

public class RomanNumberTest extends BaseTest {

    @Test
    public void testRomanConversion() {
        Assert.assertEquals("V", RomanNumber.toRoman(5));
        Assert.assertEquals("XIII", RomanNumber.toRoman(13));
        Assert.assertEquals("XLIII", RomanNumber.toRoman(43));
        Assert.assertEquals("LIV", RomanNumber.toRoman(54));
        Assert.assertEquals("LXVIII", RomanNumber.toRoman(68));
        Assert.assertEquals("LXXXI", RomanNumber.toRoman(81));
        Assert.assertEquals("CCCIV", RomanNumber.toRoman(304));
        Assert.assertEquals("CCCXXXVI", RomanNumber.toRoman(336));
        Assert.assertEquals("CDXXXIX", RomanNumber.toRoman(439));
        Assert.assertEquals("MCLXX", RomanNumber.toRoman(1170));
        Assert.assertEquals("MCCLXX", RomanNumber.toRoman(1270));
        Assert.assertEquals("MCCCXXX", RomanNumber.toRoman(1330));

        /*
        for (int i = 1000; i<= 1330; i++) {
            System.out.println(i+"\t =\t " + RomanNumber.toRoman(i));
        }
        */

    }
}
