package com.loginapp.util;

public class HashGenerator {
    public static void main(String[] args) {
        String plainPassword = "1234";
        String hashed = PasswordUtil.hashPassword(plainPassword);
        System.out.println("BCrypt hash: " + hashed);
    }
}
