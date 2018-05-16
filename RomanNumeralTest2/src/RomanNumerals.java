public class RomanNumerals {

    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String arabicToRoman(int arabic) {
        int remains = arabic;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < VALUES.length; i++) {
            remains = romanAppend(remains, VALUES[i], SYMBOLS[i], result);
        }
        return result.toString();
    }

    public static int romanAppend(int arabic, int value, String roman, StringBuilder builder){
        int result = arabic;
        while(result >= value){
            builder.append(roman);
            result -= value;
        }
        return result;
    }
}
