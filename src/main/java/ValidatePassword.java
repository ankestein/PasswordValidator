import java.util.Locale;

public class ValidatePassword {

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

    public static boolean validatePassword(String password, int minLength) {
        boolean result;
        if (checkLength(password, minLength) &&
                checkContainsNumber(password) &&
                checkContainsUpperLowerCase(password)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public static boolean[] validatePasswordList(String[] passwordList, int minLength){
        boolean[] resultList = new boolean[passwordList.length];

        for (int i = 0; i < passwordList.length; i++) {
            resultList[i] = validatePassword(passwordList[i], minLength);
        }
        return resultList;
    }

}
