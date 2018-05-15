import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralsTest {
    @Test
    public void oneTwo(){
        Assert.assertEquals("1","I", RomanNumerals.arabicToRoman(1));
        Assert.assertEquals("2", "II", RomanNumerals.arabicToRoman(2));
    }
}
