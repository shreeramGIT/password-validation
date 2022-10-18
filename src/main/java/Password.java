public enum Password {
    SHOULD_BE_LARGER_THAN_EIGHT_CHARS("^.{8,}$"),
    SHOULD_CONTAIN_ONE_UPPER_CASE_CHAR(".*[A-Z].*"),
    SHOULD_CONTAIN_ONE_LOWER_CASE_CHAR(".*[a-z].*"),
    SHOULD_CONTAIN_ONE_DIGIT(".*\\d.*");

    private String regex;

    private Password(String regex){
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public String toString() {
        return this.regex;
    }
}
