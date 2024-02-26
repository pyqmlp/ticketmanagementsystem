package dao;

import java.util.Random;


public class CaptchaUtil {
    public CaptchaUtil() {
    }

    public static String getCaptcha() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] captcha = new char[5];
        Random random = new Random();

        for (int i = 0; i < captcha.length; i++) {
            int index = random.nextInt(alphabet.length);
            captcha[i] = alphabet[index];
        }

        int number1 = random.nextInt(captcha.length);
        int number2 = random.nextInt(10);
        captcha[number1] = (char) (number2 + 48);

        return new String(captcha);

    }
}
