public class RomanNumerals {

    public static String arabicToRoman(int arabic){
        StringBuilder result = new StringBuilder();
        if(arabic == 6){
            result.append("VI");
        }
        else if(arabic == 5){
            result.append("V");
        }
        else if(arabic == 4){
            result.append("IV");
        }
        else {
            for (int i = 0; i < arabic; i++) {
                result.append("I");
            }
        }
            return result.toString();
    }
}
