package com.laddergame;

import java.util.Random;

public class RandomNumberUtil {
    private RandomNumberUtil() throws RuntimeException {
        throw new RuntimeException("Unnecessary instance generation");
    }

    private static class RandomNumberSingletonHelper {
        private static final Random random = new Random();
    }

    public static boolean exceedsThreshold() {
        int randomNumber = RandomNumberUtil.generateRandomNumber();
        return randomNumber > RandomNumberUtil.RANDOM_NUMBER_UPPER_BOUND / 2;
    }

    private static int generateRandomNumber() {
        return RandomNumberSingletonHelper.random.nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }

    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;
}
