package com.micro.data.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MicroUtils {

  private static final Random RANDOM = new Random();

  public static double generateRandomInRange(double min, double excludedMax) {
    return BigDecimal.valueOf(RANDOM.nextDouble(min, excludedMax))
        .setScale(2, RoundingMode.HALF_UP).doubleValue();
  }

  public static int generateRandomIntTo(int excludedMax) {
    return RANDOM.nextInt(0, excludedMax);
  }

  public static boolean generateBoolean() {
    return RANDOM.nextBoolean();
  }

}
