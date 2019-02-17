import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {




    @Test
    public void ShouldReturnZeroIfStringIsEmpty() {

        String result = StringCalculator.add("");

        Assert.assertEquals("0", result);
    }

    @Test
    public void ShouldReturnStringWhenThereIsOneString() {

        String result = StringCalculator.add("1.1,2.2");

        Assert.assertEquals("1.1,2.2" , result);

    }
}