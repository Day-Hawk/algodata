package gcd;

public record GreatestCommonDivisor(int value1,
                                    int value2
) {

  public int find() {
    if (this.value1 == this.value2) {
      return this.value1;
    }

    //Set on value 1 bigger value
    int latestValue1 = Math.max(this.value1, this.value2);
    //Second smaller of them
    int latestValue2 = Math.min(this.value1, this.value2);

    //Loop until value 1 is zero -> value 2 will hold the gcd.
    while (latestValue1 != 0) {
      final int loopValue1 = Math.max(latestValue1, latestValue2);
      final int loopValue2 = Math.min(latestValue1, latestValue2);

      latestValue1 = loopValue1%loopValue2;
      latestValue2 = loopValue2;
    }

    return latestValue2;
  }
}
