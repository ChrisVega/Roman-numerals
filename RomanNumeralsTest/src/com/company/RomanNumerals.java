package com.company;

import java.util.Arrays;

public class RomanNumerals {

    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String arabicToRoman(int arabic) {
        StringBuilder result = new StringBuilder();
        int remaining = arabic;
        for(int i = 0; i<VALUES.length; i++){
            remaining = appendRomanNumerals(remaining, VALUES[i],SYMBOLS[i], result);
        }
        return result.toString();
    }

    public static int romanToArabic(String roman){
        int result = 0;
        int index;
        while(!roman.equals("")){
            index = appendArabic(roman);
            result += VALUES[index];
            roman = roman.replaceFirst(SYMBOLS[index], "");
        }
        return result;
    }

    public static String[] quickSort(int start, int end, String[] roman){
        if(start<end){
            int partitionIndex = partition(start, end, roman);

            quickSort(start, partitionIndex-1, roman);
            quickSort(partitionIndex+1, end, roman);
        }
        return roman;
    }

    public static String[] sortOneLoop(String[] roman){ //Bubble sort = ew
        int length = roman.length;
        boolean valuesWereSwitched = false;
        for(int i = 0; i<length; i++){
            if(i+1 == length){
                if(!valuesWereSwitched){
                    break;
                }else{
                    i = 0;
                }
            }
            if(romanToArabic(roman[i]) > romanToArabic(roman[i+1])){
                String temp = roman[i];
                roman[i] = roman[i+1];
                roman[i+1] = temp;
                valuesWereSwitched = true;
            }
        }
        return roman;
    }

    private static int appendRomanNumerals(int arabic, int value, String romanDigits, StringBuilder builder ){
        int result = arabic;
        while(result >=value){
            builder.append(romanDigits);
            result -= value;
        }
        return result;
    }

    private static int appendArabic(String roman){
        for(int i = 0; i<SYMBOLS.length; i++){
            if(roman.startsWith(SYMBOLS[i])){
                return i;
            }
        }
        return -1;
    }

    private static int partition(int start, int end, String[] array){
        int pivot = romanToArabic(array[end]);
        String temp;
        int index = start-1;
        for(int i = start; i<end; i++){
            if(romanToArabic(array[i]) <= pivot){
                index++;
                temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }
        temp = array[index+1];
        array[index+1] = array[end];
        array[end] = temp;

        return index+1;
    }
}
