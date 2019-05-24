package com.excercise.service.utils;

import com.excercise.BaseTest;
import com.exercise.service.utils.DecimalNumberUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mario on 24/05/2019.
 */
public class DecimalNumberUtilsTest extends BaseTest {

    @Test
    public void testRomanConversion() {
        // Decimals
        Assert.assertEquals(Long.valueOf(10), DecimalNumberUtils.stringToDecimal("10"));
        Assert.assertEquals(Long.valueOf(30), DecimalNumberUtils.stringToDecimal("30"));
        Assert.assertEquals(Long.valueOf(876), DecimalNumberUtils.stringToDecimal("876"));
        Assert.assertEquals(Long.valueOf(543), DecimalNumberUtils.stringToDecimal("543"));
        Assert.assertEquals(Long.valueOf(9876), DecimalNumberUtils.stringToDecimal("9876"));

        // Binaries
        Assert.assertEquals(Long.valueOf(2), DecimalNumberUtils.binaryToDecimal("10"));
        Assert.assertEquals(Long.valueOf(85), DecimalNumberUtils.binaryToDecimal("1010101"));
        Assert.assertEquals(Long.valueOf(121), DecimalNumberUtils.binaryToDecimal("1111001"));
        Assert.assertEquals(Long.valueOf(14), DecimalNumberUtils.binaryToDecimal("1110"));
        Assert.assertEquals(Long.valueOf(42), DecimalNumberUtils.binaryToDecimal("101010"));

        // Hexas
        Assert.assertEquals(Long.valueOf(10), DecimalNumberUtils.hexaToDecimal("A"));
        Assert.assertEquals(Long.valueOf(13), DecimalNumberUtils.hexaToDecimal("D"));
        Assert.assertEquals(Long.valueOf(1535919), DecimalNumberUtils.hexaToDecimal("176FAF"));
        Assert.assertEquals(Long.valueOf(258297251), DecimalNumberUtils.hexaToDecimal("F654DA3"));
        Assert.assertEquals(Long.valueOf(11949093), DecimalNumberUtils.hexaToDecimal("B65425"));
        Assert.assertEquals(Long.valueOf(175), DecimalNumberUtils.hexaToDecimal("AF"));
        Assert.assertEquals(Long.valueOf(16), DecimalNumberUtils.hexaToDecimal("10"));
    }
}
