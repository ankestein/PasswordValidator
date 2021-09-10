import java.util.Locale;

public class ValidatePassword {

    public static String validatePassword(String password, int minLength){
        if (checkLength(password, minLength)) {
            return("password ok");
            } else {
            return("password too short");
        }
    }

    public static boolean checkLength(String password, int minLength) {
        return password.length() >= minLength;
    }


    public static boolean checkContainsNumber(String password) {
        return password.matches(".*\\d.*");
    }


    public static boolean checkContainsUpperLowerCase(String password) {
        boolean containsLower = !password.equals(password.toUpperCase());
        boolean containsUpper = !password.equals(password.toLowerCase());
        boolean containsLowerUpper = false;
        if (containsLower & containsUpper) {
            containsLowerUpper = true;
        }
        return containsLowerUpper;
    }



}
