package cn.dgut.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encoder {
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    private static String encoder(String pwd){
        return bCryptPasswordEncoder.encode(pwd);
    }

    public static void main(String[] args) {
        System.out.println(encoder("123"));
    }
}
