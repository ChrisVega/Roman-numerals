package com.company;

/*
Trying to keep methods between 4 - 15 lines long with the exception of the one loop sort
 */

public class RomanNumerals {

    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String arabicToRoman(int arabic) {
        StringBuilder result = new StringBuilder();int remaining = arabic;

        for(int i = 0; i<VALUES.length; i++){
            remaining = appendRomanNumerals(remaining, VALUES[i],SYMBOLS[i], result);
        }
        return result.toString();
    }

    public static int romanToArabic(String roman){
        int result = 0, index;

        while(!roman.equals("")){
            index = appendArabic(roman);
            result += VALUES[index];
            roman = roman.replaceFirst(SYMBOLS[index], "");
        }
        return result;
    }

    public static String[] sort(int start, int end, String[] roman){
        if(start<end){
            int partitionIndex = quickSortPartition(start, end, roman);
            sort(start, partitionIndex-1, roman);
            sort(partitionIndex+1, end, roman);
        }
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
