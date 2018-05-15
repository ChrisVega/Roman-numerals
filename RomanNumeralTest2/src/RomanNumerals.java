public class RomanNumerals {

    private static final int[]    VALUES  = {10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"X", "IX", "V", "IV", "I"};

    public static String arabicToRoman(int arabic){
        StringBuilder result = new StringBuilder();
        int remains = arabic;

            for (int i = 0; i < VALUES.length ; i++) {
               remains = appentRomanNumerals(remains, VALUES[i], SYMBOLS[i], result);
            }
            return result.toString();
    }

    public static int appentRomanNumerals(int arabic, int value, String Roman, StringBuilder builder){
        int result = arabic;
        while(result >= value){
            builder.append(Roman);
            result -= value;
        }
        return result;
    }
}
