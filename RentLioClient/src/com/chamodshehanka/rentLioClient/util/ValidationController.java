package com.chamodshehanka.rentLioClient.util;

import java.util.regex.Pattern;

/**
 * @author chamodshehanka on 4/9/2018
 * @project RentLio
 **/
public class ValidationController {

    public boolean validateTelephone(String phoneNumber){
        final Pattern pattern = Pattern.compile("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");
        return pattern.matcher(phoneNumber).matches();
    }

    public boolean validateEmail(String email){
        final Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        return emailPattern.matcher(email).matches();
    }

}
