public class RomanNumerals {

    public static String arabicToRoman(int arabic){
        StringBuilder result = new StringBuilder();
        int remains = arabic;
        if(remains == 9){
            result.append("IX");
            remains -= 9;
        }
        else if(remains  >= 5){
            result.append("V");
            remains -=5 ;
        }
        else if(remains  == 4){
            result.append("IV");
            remains -=4 ;
        }
            for (int i = 0; i < remains ; i++) {
                result.append("I");
            }
            return result.toString();
    }
}
