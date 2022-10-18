import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest {

    private PasswordValidation passwordValidation;

    @BeforeEach
    void setUp() {
        passwordValidation = new PasswordValidation();
    }

    @Test
    void testNull(){
        passwordValidation.setPassword("");
        assertEquals(0,passwordValidation.isNull());
    }

    @Test
    void testNullNegative(){
        passwordValidation.setPassword("Something");
        assertEquals(1,passwordValidation.isNull());
    }

    @Test
    void testMinimumEightChars(){
        passwordValidation.setPassword("12345678");
        assertEquals(1,passwordValidation.areMinimumEightChars());
    }

    @Test
    void testMinimumEightCharsNegative(){
        passwordValidation.setPassword("1234567");
        assertEquals(0,passwordValidation.areMinimumEightChars());
    }

    @Test
    void testShouldBeOneUpperCase(){
        passwordValidation.setPassword("abcDEefg");
        assertEquals(1,passwordValidation.isAtLeastOneUpperCaseChar());
    }

    @Test
    void testShouldBeOneUpperCaseNegative(){
        passwordValidation.setPassword("abcdefg");
        assertEquals(0,passwordValidation.isAtLeastOneUpperCaseChar());
    }

    @Test
    void testShouldBeOneLowerCase(){
        passwordValidation.setPassword("AASHJsASD");
        assertEquals(1,passwordValidation.isAtLeastOneLowerCaseChar());
    }

    @Test
    void testShouldBeOneLowerCaseNegative(){
        passwordValidation.setPassword("AASHJSASD");
        assertEquals(0,passwordValidation.isAtLeastOneLowerCaseChar());
    }

    @Test
    void testShouldContainOneDigit(){
        passwordValidation.setPassword("Ashhsj12HGGha");
        assertEquals(1,passwordValidation.isAtLeastOneDigit());
    }

    @Test
    void testShouldContainOneDigitNegative(){
        passwordValidation.setPassword("AshhsjHGGha");
        assertEquals(0,passwordValidation.isAtLeastOneDigit());
    }

    @Test
    void testIsPasswordScoreStrong() throws Exception {
        passwordValidation.setPassword("ABC1EFg");
        assertTrue(passwordValidation.isPasswordStrong());
    }

    /**
     * This test case should pass as at least three conditions are met
     * Not null, At Least One upper and 8 chars
     * @throws Exception
     */
    @Test
    void testIsPasswordScoreStrong_onlyUppercaseChars_8Chars_NotNull() throws Exception {
        passwordValidation.setPassword("ABCEFSHHHJS");
        assertTrue(passwordValidation.isPasswordStrong());
    }

    @Test
    void testIsPasswordScoreStrong_Uppercase_Lowercase_Nodigit() throws Exception {
        passwordValidation.setPassword("ABCsdFg");
        assertTrue(passwordValidation.isPasswordStrong());
    }

    @Test
    void testIsPasswordScoreStrong_Uppercase_NoLowercase_Nodigit_LessThan8() throws Exception {
        passwordValidation.setPassword("ABCF");
        assertThrows(Exception.class,()->passwordValidation.isPasswordStrong());
    }

    @Test
    void testIsPasswordAllowed() throws Exception {
        passwordValidation.setPassword("ABCDE23HJHks");
        assertTrue(passwordValidation.isPasswordAllowed());
    }

    @Test
    void testIsPasswordAllowedNegative() throws Exception {
        passwordValidation.setPassword("ASD");
        assertThrows(Exception.class,()->passwordValidation.isPasswordAllowed());
    }
}