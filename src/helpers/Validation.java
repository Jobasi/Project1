package helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 07/10/2016.
 */
public class Validation {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String email){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
    }
    public static boolean validatePhoneNumber(Long phoneNumber){
        return true;
    }
}
