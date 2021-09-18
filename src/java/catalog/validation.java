package catalog;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class validation {

    public static boolean validateString(String str, String len) {
        if (Pattern.matches("[a-zA-Z ]{" + len + "}", str)) {
            return true;
        }
        return false;
    }

    public static boolean validatePassword(String str, String len) {
        String ab;
        ab = "~!@#$%^&*()_+?.,<>|";
        if (Pattern.matches("[a-zA-Z0-9" + ab + "]{" + len + "}", str)) {
            return true;
        }
        return false;
    }

    public static boolean validatePhone(String str, String len) {
        if (Pattern.matches("[0-9]{" + len + "}", str)) {
            return true;
        }
        return false;
    }

    public static boolean validateQuali(String str, String len) {
        if (Pattern.matches("[a-zA-Z0-9 ]{" + len + "}", str)) {
            return true;
        }
        return false;
    }
    
    public static boolean validateEmail(String str, String len) {
        if (Pattern.matches("^[A-Za-z][A-Za-z0-9+_.-]+@(.+)${" + len + "}", str)) {
            return true;
        }
        return false;
    }
    
    public static boolean validateSalary(String str, String len){
      if (Pattern.matches("[0-9]+([,.][0-9]{1,2})?{" + len + "}", str)) {
            return true;
        }
        return false;  
    }
    
    public static boolean validateWeek(String str,String len){
        if (Pattern.matches("[a-zA-Z,]{" + len + "}", str)) {
            return true;
        }
        return false;
    }
    
    public static boolean SignIn(String str,String len){
       if (Pattern.matches("^([0-1]?[0-9]|2[0-4]):([0-5][0-9])(:[0-5][0-9])?${" + len + "}", str)) {
            return true;
        }
        return false;  
    }
    
    public static String encryptSha512(String val){
         try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(val.getBytes());
            BigInteger number = new BigInteger(1,messageDigest);
            String hashtext = number.toString(16);
            return hashtext;
        } catch (NoSuchAlgorithmException ex) {
          throw new RuntimeException(ex);
        }
    }
    public static String encryptMd5(String val){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(val.getBytes());
            BigInteger number = new BigInteger(1,messageDigest);
            String hashtext = number.toString(16);
            return hashtext;
        } catch (NoSuchAlgorithmException ex) {
          throw new RuntimeException(ex);
        }
    }
}
