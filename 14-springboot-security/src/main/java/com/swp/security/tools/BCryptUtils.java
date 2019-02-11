package com.swp.security.tools;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-02-11 10:39 AM
 */
public class BCryptUtils {

    public static String encode(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode(password);
        return encode;
    }

}
