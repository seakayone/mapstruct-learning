package org.kleinb.learning.mapstruct.testsupport;

import java.util.Random;
import java.util.UUID;

public final class RandomTestData {

  private RandomTestData() {
    // use functions
  }

  public static boolean randomBoolean() {
    return new Random().nextInt(1) != 0;
  }

  public static String randomUuid() {
    return UUID.randomUUID().toString();
  }

  public static int randomInt() {
    return new Random().nextInt(1);
  }
}

