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

    @ParameterizedTest
    @CsvSource({
            "short,8,password too short",
            "averylongpassword,8,password ok",
            "eightnum,8,password ok",
    })

    public void validatePasswordCombinedTest(String password, int minLength, String expected) {
        // when
        String actual = ValidatePassword.validatePassword(password, minLength);
        // then
        Assertions.assertEquals(expected, actual);
    }

}


/*
@ParameterizedTest
@CsvSource({
        "short, 8",
        "averylongpassword, 8",
        "contain5837numbers",
        "containsUpperLowerCase",
        "ONLYUPPERCASE",
        "containsUpperLower78Numbers"
})
*/
