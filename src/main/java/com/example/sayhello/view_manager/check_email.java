package com.example.sayhello.view_manager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class check_email {
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.com+$";

    public static boolean isEmailValid(String email) throws InvalidEmailException {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            return true;
        } else {
            throw new InvalidEmailException("Invalid email format: " + email);
        }
    }

}

