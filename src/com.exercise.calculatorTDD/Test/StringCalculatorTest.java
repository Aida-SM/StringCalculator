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
    public void shouldReturnStringWhenThereIsOneNumberAsString() {

        String result = calculator.add("1.1");

        Assert.assertEquals("1.1" , result);

    }

    @Test
    public void shouldReturnSumOfTwoNumberAsStringSeparatedByComma () {

        String result = calculator.add("1,2");

        Assert.assertEquals("3", result);
    }

    @Test
    public void shouldReturnSumOfMultipleNumbersSeparatedByComma() {

        String result = calculator.add("1,2,3,4");
        Assert.assertEquals("10", result);

    }

    @Test
    public void shouldReturnSumOfMultipleNumbersSeparatedByNewline() {

        String result = calculator.add("1\n2");
        Assert.assertEquals("3", result);

    }

    @Test
    public void shouldReturnTheErrorMessageWhenNewlineComBesideComma() {
        String result = calculator.add("1\n,2");
        Assert.assertEquals("Wrong input" , result);
    }

}