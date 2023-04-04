package org.example.utils;

import java.util.Random;

public class Generic {
    public static String generateRandomEmail() {
        String ALPHABET_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String IntRandom="0123456789";
        int STRING_LENGTH = 5;
        StringBuilder sb = new StringBuilder(STRING_LENGTH);
        Random random = new Random();
        for (int i = 0; i < STRING_LENGTH; i++) {
            sb.append(ALPHABET_CHARS.charAt(random.nextInt(ALPHABET_CHARS.length())));
            sb.append(IntRandom.charAt(random.nextInt(IntRandom.length())));
        }
        String email =sb+"@gmail.com";
        return email;
    }
}
