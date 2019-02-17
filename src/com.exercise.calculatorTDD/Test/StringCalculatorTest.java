import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {


    @Test
    public void ShouldReturnZeroIfStringIsEmpty() {

        String result = StringCalculator.add("");

        Assert.assertEquals("0", result);


    }
}