import Exceptions.PasswordNotStrongException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;

public class Main {

    private static PasswordValidation passwordValidation = new PasswordValidation();
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            PasswordList passwordList = mapper.readValue(Paths.get("src/main/resources/passwords.json").toFile(),PasswordList.class);
            passwordList.password.forEach(pass ->{
                try {
                    passwordValidation.setPassword(pass);
                    if(!passwordValidation.isPasswordAllowed()){
                        throw new PasswordNotStrongException("Password " + pass +  "Not allowed");
                    }else {
                        System.out.println("\u001B[32m"+ "Password "+pass+ " is allowed"+"\u001B[0m");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
