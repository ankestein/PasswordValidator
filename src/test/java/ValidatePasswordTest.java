import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidatePasswordTest {

    @Test
    public void checkLengthShortTest() {
        // given
        String password = "short";
        int minLength = 8;
        // when
        boolean actual = ValidatePassword.checkLength(password, minLength);
        // then
        Assertions.assertEquals(false, actual);
    }

    @Test
    public void checkLengthLongTest() {
        // given
        String password = "averylongpassword";
        int minLength = 8;
        // when
        boolean actual = ValidatePassword.checkLength(password, minLength);
        // then
        Assertions.assertEquals(true, actual);
    }

    @Test
    public void checkLengthCornerCaseTest() {
        // given
        String password = "eightnum";
        int minLength = 8;
        // when
        boolean actual = ValidatePassword.checkLength(password, minLength);
        // then
        Assertions.assertEquals(true, actual);
    }

    @Test
    public void checkContainsNumberNoTest() {
        // given
        String password = "nonumber";
        // when
        boolean actual = ValidatePassword.checkContainsNumber(password);
        // then
        Assertions.assertEquals(false, actual);
    }

    @Test
    public void checkContainsNumberYesTest() {
        // given
        String password = "some789numbers";
        // when
        boolean actual = ValidatePassword.checkContainsNumber(password);
        // then
        Assertions.assertEquals(true, actual);
    }


    @Test
    public void checkContainsUpperLowerCaseOnlyLowerTest() {
        // given
        String password = "onlylowercase";
        // when
        boolean actual = ValidatePassword.checkContainsUpperLowerCase(password);
        // then
        Assertions.assertEquals(false, actual);
    }

    @Test
    public void checkContainsUpperLowerCaseOnlyUpperTest() {
        // given
        String password = "ONLYUPPERCASE";
        // when
        boolean actual = ValidatePassword.checkContainsUpperLowerCase(password);
        // then
        Assertions.assertEquals(false, actual);
    }

    @Test
    public void checkContainsUpperLowerCaseUpperLowerTest() {
        // given
        String password = "lowerAndUPPERCASE";
        // when
        boolean actual = ValidatePassword.checkContainsUpperLowerCase(password);
        // then
        Assertions.assertEquals(true, actual);
    }




    @ParameterizedTest
    @CsvSource({
            "short, 8, false",
            "averylongpassword, 8, false",
            "contain5837numbers, 8, false",
            "containsUpperLowerCase, 8, false",
            "ONLYUPPERCASE, 8, false",
            "containsUpperLower78Numbers, 8, true"
    })

    public void validatePasswordCombinedTest(String password, int minLength, boolean expected) {
        // when
        boolean actual = ValidatePassword.validatePassword(password, minLength);
        // then
        Assertions.assertEquals(expected, actual);
    }

}


/*
@ParameterizedTest

*/
