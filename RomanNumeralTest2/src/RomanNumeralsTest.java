import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralsTest {
    @Test
    public void oneTwoThree() {
        Assert.assertEquals("1", "I", RomanNumerals.arabicToRoman(1));
        Assert.assertEquals("2", "II", RomanNumerals.arabicToRoman(2));
        Assert.assertEquals("3", "III", RomanNumerals.arabicToRoman(3));
    }

    @Test
    public void four() {
        Assert.assertEquals("4", "IV", RomanNumerals.arabicToRoman(4));
    }

    @Test
    public void five() {
        Assert.assertEquals("5", "V", RomanNumerals.arabicToRoman(5));
    }

    @Test
    public void sixSevenEight() {
        Assert.assertEquals("6", "VI", RomanNumerals.arabicToRoman(6));
        Assert.assertEquals("7", "VII", RomanNumerals.arabicToRoman(7));
        Assert.assertEquals("8", "VIII", RomanNumerals.arabicToRoman(8));
    }

    @Test
    public void nine() {
        Assert.assertEquals("9", "IX", RomanNumerals.arabicToRoman(9));
    }

    @Test
    public void ten() {
        Assert.assertEquals("10", "X", RomanNumerals.arabicToRoman(10));
    }

    @Test
    public void RN836() {
        Assert.assertEquals("836", "DCCCXXXVI", RomanNumerals.arabicToRoman(836));
    }
}
