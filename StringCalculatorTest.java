package vdevelopers.jvd;

import junit.framework.Assert;

import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void testAddStep1() {
        Assert.assertEquals(0, StringCalculator.add(""));
        Assert.assertEquals(1, StringCalculator.add("1"));
        Assert.assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void testAddStep2() {
        Assert.assertEquals(39, StringCalculator.add("1,2,3,4,5,6,18"));
        Assert.assertEquals(100, StringCalculator.add(get100ValuePlusOne()));

    }

    private String get100ValuePlusOne() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 100; i++) {
            if (buffer.toString().isEmpty()) {
                buffer.append("1");
            } else {
                buffer.append(",");
                buffer.append("1");
            }
        }

        return buffer.toString();
    }

}
