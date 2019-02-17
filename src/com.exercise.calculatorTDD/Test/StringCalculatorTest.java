import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    StringCalculator calculator ;
    @Before

    public void setUp() throws Exception {
        calculator = new StringCalculator();
    }

    @Test
    public void ShouldReturnZeroIfStringIsEmpty() {

        String result = calculator.add("");

        Assert.assertEquals("0", result);
    }

    @Test
    public void ShouldReturnStringWhenThereIsOneNumberAsString() {

        String result = calculator.add("1.1");

        Assert.assertEquals("1.1" , result);

    }

    @Test
    public void ShouldReturnSumOfTwoNumberAsStringSeparatedByCamma () {

        String result = calculator.add("1,2");

        Assert.assertEquals("3", result);
    }
}