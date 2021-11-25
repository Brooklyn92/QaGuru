package hw4.utils;

import java.util.Random;

public class RandomUtils {
    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * (SALTCHARS.length()-1));
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }
}
