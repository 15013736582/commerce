package com.util;

import org.springframework.util.DigestUtils;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-28 21:52
 **/
public class PasswordUtil {

    public String getSAIT() {
        return SAIT;
    }

    private final String SAIT = "ajfd35nvcxv-395jzcvAJFNIFNSF)@";

    public static String passwordCreate(String password){
        password = password + new PasswordUtil().getSAIT();
        password =  DigestUtils.md5DigestAsHex(password.getBytes());
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        return password;
    }

}
