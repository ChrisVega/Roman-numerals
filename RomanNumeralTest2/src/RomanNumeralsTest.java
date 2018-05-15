import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralsTest {
    @Test
    public void one(){
        Assert.assertEquals("1","I",RomanNumerals.arabicToRoman(1));
    }
}
