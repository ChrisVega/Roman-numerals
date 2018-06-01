package com.company;

/*
For roman numerals 4000 and above you would use a line over that numeral to indicate that it is 1000 times larger.
Over line unicode doesn't seem to be supported for console output so a numeral in between '' would indicate times
1000 instead. Ex 4000 == 'IV'
 */

public class RomanNumerals {

    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String arabicToRoman(int arabic) {
        StringBuilder result = new StringBuilder();int remaining = arabic;
        if(arabic>3999){
            result.append("'");
        }
        for(int i = 0; i<VALUES.length; i++){
            remaining = appendRomanNumerals(remaining, VALUES[i],SYMBOLS[i], result);
        }
        return result.toString();
    }

    public static int romanToArabic(String roman){
        int result = 0;
        if (roman.contains("'")) {
            String[] split = roman.split("'");
            result = 1000 * romanToArabic(split[1]);
            roman = split[2];
        }
        for(int i = 0; i<SYMBOLS.length; i++){
            while(roman.startsWith(SYMBOLS[i])){
                result += VALUES[i];
                roman = roman.replaceFirst(SYMBOLS[i], "");
            }
        }
        return result;
    }

    public static String[] sort(String[] roman){
        int start = 0; int end = roman.length-1;
        quickSort(start, end, roman);
        return roman;
    }

    public static String[] sortOneLoop(String[] roman){ //if(bubbleSort) return ew;
        int length = roman.length; boolean valuesWereSwitched = false;
        for(int i = 0; i<length; i++){
            if(i+1 == length){
                if(!valuesWereSwitched){
                    break;
                }else{
                    i = 0;
                }
            }
            if(romanToArabic(roman[i]) > romanToArabic(roman[i+1])){
                swap(i, i+1, roman);
                valuesWereSwitched = true;
            }
        }
        return roman;
    }

    private static int appendRomanNumerals(int arabic, int value, String romanDigits, StringBuilder builder){
        int result = arabic;
        while(result >= value) {
            if (result > 3999) {
                result = appendRomanForValuesOver3999(result, builder);
            } else {
                builder.append(romanDigits);
                result -= value;
            }
        }
        return result;
    }

    private static int appendRomanForValuesOver3999(int result, StringBuilder builder){
        int thousandsPortion = getThousandsPortion(result);
        int index = 0;
            while(VALUES[++index] > thousandsPortion);
        result -= VALUES[index]*1000;
        builder.append(SYMBOLS[index]);
        if(result < 4000) {
            builder.append("'");
        }
        return result;
    }

    private static int getThousandsPortion(int result) {
        int thousandsPortion;
        if(result >= 10000){
            thousandsPortion = (result / 10000)*10;
        } else {
            thousandsPortion = (result / 1000);
        }
        return thousandsPortion;
    }

    private static String[] quickSort(int start, int end, String[] roman){
        if(start<end){
            int partitionIndex = quickSortPartition(start, end, roman);
            quickSort(start, partitionIndex-1, roman);
            quickSort(partitionIndex+1, end, roman);
        }
        return roman;
    }

    private static int quickSortPartition(int start, int end, String[] array){
        int pivot = romanToArabic(array[end]);
        int index = start-1;
        for(int i = start; i<end; i++){
            if(romanToArabic(array[i]) <= pivot){
                index++;
                swap(index, i, array);
            }
        }
        swap(index+1, end, array);
        return index+1;
    }

    private static void swap (int indexFirst, int indexSecond, String[] array){
        String temp;
        temp = array[indexFirst];
        array[indexFirst] = array[indexSecond];
        array[indexSecond] = temp;
    }
}
