import Exceptions.*;

public class PasswordValidation {

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public Integer isNull() {
        return Validator.isNull(password);
    }

    public Integer areMinimumEightChars() {
        return Validator.isLargerThanEightChars(password);
    }

    public Integer isAtLeastOneUpperCaseChar() {
        return Validator.validateIfAnyUpperCase(password);
    }

    public Integer isAtLeastOneLowerCaseChar() {
        return  Validator.validateIfAnyLowerCase(password);
    }

    public Integer isAtLeastOneDigit() {
        return Validator.validateIfAnyDigit(password);
    }

    public Boolean isPasswordStrong() throws Exception {
        Boolean isPasswordStrong =  isNull()
                + areMinimumEightChars()
                + isAtLeastOneUpperCaseChar()
                + isAtLeastOneLowerCaseChar()
                + isAtLeastOneDigit() >= 3;

        String errorMessage="\u001B[31m";
        if(!isPasswordStrong){
            if(isNull()==0)
                errorMessage += "password " +password+ " should not be null\n";
            if(isAtLeastOneUpperCaseChar()==0)
                errorMessage += "password " +password+ " should have one uppercase letter at least\n";
            if(isAtLeastOneLowerCaseChar()==0)
                errorMessage += "password " +password+ " should have one lowercase letter at least\n";
            if(areMinimumEightChars()==0)
                errorMessage += "password " +password+ " should be larger than 8 chars\n";
            if (isAtLeastOneDigit()==0)
                errorMessage += "password " +password+ " should have one number at least\n";
            throw new PasswordNotStrongException(errorMessage+"\u001B[0m");
        }
        return isPasswordStrong;
    }


    public Boolean isPasswordAllowed() throws Exception {
        if(isAtLeastOneLowerCaseChar() == 0)
            throw new NoLowerCaseException("\u001B[31m"+"password should have one lowercase letter at least"+"\u001B[0m");
        return (isAtLeastOneLowerCaseChar() == 1) && isPasswordStrong();
    }
}
