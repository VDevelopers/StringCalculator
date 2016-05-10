package vdevelopers.jvd;

import junit.framework.Assert;

import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void testAddOk() {
        Assert.assertEquals(0, StringCalculator.add(""));
        Assert.assertEquals(1, StringCalculator.add("1"));
        Assert.assertEquals(3, StringCalculator.add("1,2"));
    }

}
