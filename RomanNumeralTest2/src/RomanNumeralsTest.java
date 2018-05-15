import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralsTest {
    @Test
    public void oneTwoThree(){
        Assert.assertEquals("1","I", RomanNumerals.arabicToRoman(1));
        Assert.assertEquals("2", "II", RomanNumerals.arabicToRoman(2));
        Assert.assertEquals("3", "III", RomanNumerals.arabicToRoman(3));
    }

    @Test
    public void four(){
        Assert.assertEquals("4", "IV", RomanNumerals.arabicToRoman(4));
    }

    @Test
    public void five(){
        Assert.assertEquals("5", "V", RomanNumerals.arabicToRoman(5));
    }
}
