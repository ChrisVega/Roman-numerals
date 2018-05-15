import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralsTest {
    @Test
    public void oneTwoThree(){
        Assert.assertEquals("1","I", RomanNumerals.arabicToRoman(1));
        Assert.assertEquals("2", "II", RomanNumerals.arabicToRoman(2));
        Assert.assertEquals("3", "III", RomanNumerals.arabicToRoman(3));
    }
}
