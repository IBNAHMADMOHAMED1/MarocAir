package com.marocair.lib;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class HashPassword {
    Argon2 argon2 = Argon2Factory.create();

    public String hashPassword(String password) {
        String hash = null;
        try {
            // Hash password
            hash = argon2.hash(10, 65536, 1, password);
            System.out.println(hash);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }

    public String verifyPassword(String hashedPassword, String password) {
        if (argon2.verify(hashedPassword, password)) {
            System.out.println("susuus"+ password);
            return "success";
        } else {
            return "failed";
            // Hash doesn't match password
        }
    }
}
