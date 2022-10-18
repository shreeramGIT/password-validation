import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Map<String, Pattern> regexMap = new HashMap<>();
    static {
        regexMap.put("SHOULD_BE_LARGER_THAN_EIGHT_CHARS",Pattern.compile(Password.SHOULD_BE_LARGER_THAN_EIGHT_CHARS.getRegex()));
        regexMap.put("SHOULD_CONTAIN_ONE_UPPER_CASE_CHAR",Pattern.compile(Password.SHOULD_CONTAIN_ONE_UPPER_CASE_CHAR.getRegex()));
        regexMap.put("SHOULD_CONTAIN_ONE_LOWER_CASE_CHAR",Pattern.compile(Password.SHOULD_CONTAIN_ONE_LOWER_CASE_CHAR.getRegex()));
        regexMap.put("SHOULD_CONTAIN_ONE_DIGIT",Pattern.compile(Password.SHOULD_CONTAIN_ONE_DIGIT.getRegex()));
    }
    static public Integer isLargerThanEightChars(String password){
        return passwordScore(regexMap.get("SHOULD_BE_LARGER_THAN_EIGHT_CHARS").matcher(password));
    }

    public static Integer validateIfAnyUpperCase(String password) {
        return passwordScore(regexMap.get("SHOULD_CONTAIN_ONE_UPPER_CASE_CHAR").matcher(password));
    }

    public static Integer validateIfAnyLowerCase(String password) {
        return passwordScore(regexMap.get("SHOULD_CONTAIN_ONE_LOWER_CASE_CHAR").matcher(password));
    }

    public static Integer validateIfAnyDigit(String password) {
        return passwordScore(regexMap.get("SHOULD_CONTAIN_ONE_DIGIT").matcher(password));
    }

    public static Integer passwordScore(Matcher matcher){
        return matcher.matches() ? 1 : 0;
    }

    public static Integer isNull(String password) {
        return password.isEmpty() ? 0 : 1;
    }
}
