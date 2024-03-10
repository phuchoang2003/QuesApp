package com.example.utility;
import org.mindrot.jbcrypt.BCrypt;

public class Encryption {
        public static String encryptPassword(String password) {
            return BCrypt.hashpw(password, BCrypt.gensalt());
        }

        public static boolean checkPassword(String password, String hashedPassword) {
            return BCrypt.checkpw(password, hashedPassword);
        }
    }

