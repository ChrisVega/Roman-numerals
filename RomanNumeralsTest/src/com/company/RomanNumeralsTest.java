package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RomanNumeralsTest {
    private int[] testCaseArabic = {6, 8, 7, 3, 5, 1, 9, 4, 2, 10};
    private String[] expected = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

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
    public void RND836() {
        Assert.assertEquals("836", "DCCCXXXVI", RomanNumerals.arabicToRoman(836));
    }

    @Test
    public void romanToArabic() {
        Assert.assertEquals("I",1, RomanNumerals.romanToArabic("I"));
        Assert.assertEquals("III",3, RomanNumerals.romanToArabic("III"));
        Assert.assertEquals("IX",9, RomanNumerals.romanToArabic("IX"));
        Assert.assertEquals("DCCCXXXVI",836, RomanNumerals.romanToArabic("DCCCXXXVI"));
    }

    @Test
    public void sortTest(){
        String roman[] = new String[testCaseArabic.length];
        int i = 0;
        for(int arabic: testCaseArabic){
            roman[i] = RomanNumerals.arabicToRoman(arabic);
            i++;
        }
        Assert.assertArrayEquals(expected, RomanNumerals.quickSort(0,(roman.length-1) ,roman));
        System.out.println(Arrays.toString(RomanNumerals.quickSort(0,(roman.length-1) ,roman)));
        Assert.assertArrayEquals(expected, RomanNumerals.sortOneLoop(roman));
        System.out.println(Arrays.toString(RomanNumerals.sortOneLoop(roman)));
    }

}
