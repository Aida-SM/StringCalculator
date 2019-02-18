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

        String result = calculator.add("1.1,2.1,3,4");
        Assert.assertEquals("10.2", result);

    }

    @Test
    public void shouldReturnSumOfMultipleNumbersSeparatedByNewline() {

        String result = calculator.add("1.01\n2");
        Assert.assertEquals("3.01", result);

    }

    @Test
    public void shouldReturnTheErrorMessageWhenNewlineComBesideCommaWithShowingThePosition() {
        String result = calculator.add("175.2\n,35");
        Assert.assertEquals("Number expected but '\n' found at position 6." , result);

    }

    @Test
    public void shouldReturnTheErrorMessageWhenMissingNumberInLastPosition() {
        String result = calculator.add("1,3,");
        Assert.assertEquals("Number expected but EOF found" , result);

    }

    @Test
    public void shouldReturnSumOfTwoNumbersWithStringStartedWithCustomSeparator() {
        String result = calculator.add("//s\n2.1s5s3.01");
        Assert.assertEquals("10.11" , result);

    }

    @Test
    public void shouldReturnTheErrorMessageWhenStringHasTwoDifferentSeparator() {
        String result = calculator.add("//|\n1|20,3");
        Assert.assertEquals("| expected but , found at position 4" , result);

    }

    @Test
    public void shouldReturnTheErrorMessageWhenThereIsANegativeNumber() {
        String result = calculator.add("-1,2");
        Assert.assertEquals("Negative not allowed : -1", result);
    }


}