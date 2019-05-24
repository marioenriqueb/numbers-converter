package com.excercise.service;

import com.excercise.BaseTest;
import com.exercise.exception.NumberConvertException;
import com.exercise.service.ConverterService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mario on 24/05/2019.
 */
public class ConverterServiceTest extends BaseTest {

    @Autowired
    private ConverterService service;

    @Test
    public void binariesTest() throws NumberConvertException {
        Assert.assertEquals("2", service.binarioToDecimal("10").getResult());
        Assert.assertEquals("2", service.binarioToHexa("10").getResult());
        Assert.assertEquals("II", service.binarioToRomano("10").getResult());
        Assert.assertEquals("10", service.binarioToBinario("10").getResult());
    }

    @Test
    public void hexaTest() throws NumberConvertException {
        Assert.assertEquals("10", service.hexaToDecimal("A").getResult());
        Assert.assertEquals("A", service.hexaToHexa("A").getResult());
        Assert.assertEquals("X", service.hexaToRomano("A").getResult());
        Assert.assertEquals("1010", service.hexaToBinario("A").getResult());
    }

    @Test
    public void decimalTest() throws NumberConvertException {
        Assert.assertEquals("55", service.decimalToDecimal("55").getResult());
        Assert.assertEquals("37", service.decimalToHexa("55").getResult());
        Assert.assertEquals("LV", service.decimalToRomano("55").getResult());
        Assert.assertEquals("110111", service.decimalToBinario("55").getResult());
    }
}
