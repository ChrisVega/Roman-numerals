package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RomanNumeralsTest {
    private int[] testCaseArabic = {6, 8, 7, 3, 5, 1, 9, 4, 2, 10};
    private String[] expected = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    @Test
    public void testOneTwoThree() {
        Assert.assertEquals("1", "I", RomanNumerals.arabicToRoman(1));
        Assert.assertEquals("2", "II", RomanNumerals.arabicToRoman(2));
        Assert.assertEquals("3", "III", RomanNumerals.arabicToRoman(3));
    }

    @Test
    public void testFour() {
        Assert.assertEquals("4", "IV", RomanNumerals.arabicToRoman(4));
    }

    @Test
    public void testFive() {
        Assert.assertEquals("5", "V", RomanNumerals.arabicToRoman(5));
    }

    @Test
    public void testSixSevenEight() {
        Assert.assertEquals("6", "VI", RomanNumerals.arabicToRoman(6));
        Assert.assertEquals("7", "VII", RomanNumerals.arabicToRoman(7));
        Assert.assertEquals("8", "VIII", RomanNumerals.arabicToRoman(8));
    }

    @Test
    public void testNine() {
        Assert.assertEquals("9", "IX", RomanNumerals.arabicToRoman(9));
    }

    @Test
    public void testTen() {
        Assert.assertEquals("10", "X", RomanNumerals.arabicToRoman(10));
    }

    @Test
    public void testSixty() {
        Assert.assertEquals("60", "LX", RomanNumerals.arabicToRoman(60));
    }

    @Test
    public void testThousands() {
        Assert.assertEquals("1000", "M", RomanNumerals.arabicToRoman(1000));
        Assert.assertEquals("2000", "MM", RomanNumerals.arabicToRoman(2000));
        Assert.assertEquals("3000", "MMM", RomanNumerals.arabicToRoman(3000));
        Assert.assertEquals("4000", "'IV'", RomanNumerals.arabicToRoman(4000));
        Assert.assertEquals("5000", "'V'", RomanNumerals.arabicToRoman(5000));
        Assert.assertEquals("6000", "'V'M", RomanNumerals.arabicToRoman(6000));
        Assert.assertEquals("7000", "'V'MM", RomanNumerals.arabicToRoman(7000));
        Assert.assertEquals("8000", "'V'MMM", RomanNumerals.arabicToRoman(8000));
        Assert.assertEquals("9000", "'IX'", RomanNumerals.arabicToRoman(9000));
        Assert.assertEquals("10000", "'X'", RomanNumerals.arabicToRoman(10000));
        Assert.assertEquals("60000", "'LX'", RomanNumerals.arabicToRoman(60000));
        Assert.assertEquals("100000", "'C'", RomanNumerals.arabicToRoman(100000));
        Assert.assertEquals("600000", "'DC'", RomanNumerals.arabicToRoman(600000));
    }

    @Test
    public void testRandomNumbers() {
        Assert.assertEquals("836", "DCCCXXXVI", RomanNumerals.arabicToRoman(836));
        Assert.assertEquals("2459", "MMCDLIX", RomanNumerals.arabicToRoman(2459));
        Assert.assertEquals("6934", "'V'MCMXXXIV", RomanNumerals.arabicToRoman(6934));
        Assert.assertEquals("53313", "'L'MMMCCCXIII", RomanNumerals.arabicToRoman(53313));
        Assert.assertEquals("59313", "'LIX'CCCXIII", RomanNumerals.arabicToRoman(59313));
        Assert.assertEquals("891751", "'DCCCXC'MDCCLI", RomanNumerals.arabicToRoman(891751));
        Assert.assertEquals("831751", "'DCCCXXX'MDCCLI", RomanNumerals.arabicToRoman(831751));
    }

    @Test
    public void testRomanToArabic() {
        Assert.assertEquals("I",1, RomanNumerals.romanToArabic("I"));
        Assert.assertEquals("III",3, RomanNumerals.romanToArabic("III"));
        Assert.assertEquals("IX",9, RomanNumerals.romanToArabic("IX"));
        Assert.assertEquals("836", 836, RomanNumerals.romanToArabic("DCCCXXXVI"));
        Assert.assertEquals("2459", 2459, RomanNumerals.romanToArabic("MMCDLIX"));
        Assert.assertEquals("6934", 6934, RomanNumerals.romanToArabic("'V'MCMXXXIV"));
        Assert.assertEquals("53313", 53313, RomanNumerals.romanToArabic("'L'MMMCCCXIII"));
        Assert.assertEquals("59313", 59313, RomanNumerals.romanToArabic("'LIX'CCCXIII"));
        Assert.assertEquals("891751", 891751, RomanNumerals.romanToArabic("'DCCCXC'MDCCLI"));
        Assert.assertEquals("831751", 831751, RomanNumerals.romanToArabic("'DCCCXXX'MDCCLI"));
    }

    @Test
    public void testSort(){
        String roman[] = new String[testCaseArabic.length];
        int i = 0;
        for(int arabic: testCaseArabic){
            roman[i] = RomanNumerals.arabicToRoman(arabic);
            i++;
        }
        Assert.assertArrayEquals(expected, RomanNumerals.sort(roman));
        System.out.println(Arrays.toString(RomanNumerals.sort(roman)));
        Assert.assertArrayEquals(expected, RomanNumerals.sortOneLoop(roman));
        System.out.println(Arrays.toString(RomanNumerals.sortOneLoop(roman)));
    }

}
