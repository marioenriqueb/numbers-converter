package com.excercise.service.utils;

import com.excercise.BaseTest;
import com.exercise.service.utils.RomanNumberUtils;
import org.junit.Assert;
import org.junit.Test;

public class RomanNumberUtilsTest extends BaseTest {

    @Test
    public void testRomanConversion() {
        Assert.assertEquals("V", RomanNumberUtils.toRoman(5L));
        Assert.assertEquals("XIII", RomanNumberUtils.toRoman(13L));
        Assert.assertEquals("XLIII", RomanNumberUtils.toRoman(43L));
        Assert.assertEquals("LIV", RomanNumberUtils.toRoman(54L));
        Assert.assertEquals("LXVIII", RomanNumberUtils.toRoman(68L));
        Assert.assertEquals("LXXXI", RomanNumberUtils.toRoman(81L));
        Assert.assertEquals("CCCIV", RomanNumberUtils.toRoman(304L));
        Assert.assertEquals("CCCXXXVI", RomanNumberUtils.toRoman(336L));
        Assert.assertEquals("CDXXXIX", RomanNumberUtils.toRoman(439L));
        Assert.assertEquals("MCLXX", RomanNumberUtils.toRoman(1170L));
        Assert.assertEquals("MCCLXX", RomanNumberUtils.toRoman(1270L));
        Assert.assertEquals("MCCCXXX", RomanNumberUtils.toRoman(1330L));

        /*
        for (int i = 1000; i<= 1330; i++) {
            System.out.println(i+"\t =\t " + RomanNumberUtils.toRoman(i));
        }
        */

    }
}
