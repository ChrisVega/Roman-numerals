public class RomanNumerals {

    public static String arabicToRoman(int arabic){
        StringBuilder result = new StringBuilder();
            for(int i = 0; i<arabic; i++){
                result.append("I");
            }
            return result.toString();
    }
}
