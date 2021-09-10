import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidatePasswordTest {

    @Test
    public void checkLengthTest() {
        // given
        String password = "short";
        int minLength = 8;
        // when
        boolean actual = ValidatePassword.checkLength(password, minLength);
        // then
        Assertions.assertEquals(false, actual);
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
