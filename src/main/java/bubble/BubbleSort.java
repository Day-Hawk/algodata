package bubble;

import java.util.function.BiPredicate;


public record BubbleSort<ENTITY>(ENTITY[] list,
                                 BiPredicate<ENTITY, ENTITY> testLeft
) {

  public ENTITY[] sort() {
    return this.sort(this.list.length);
  }

  private ENTITY[] sort(final int searchUntil) {
    //Throw error if max length -> illegal state
    if (searchUntil>this.list.length) {
      throw new IllegalArgumentException(
          "Value of searchUntil="+searchUntil+" is out of range="+this.list.length+".");
    }

    int currentIndex = 0;

    //Loop until done
    while (currentIndex<searchUntil-1) {
      final ENTITY base = this.list[currentIndex];
      final ENTITY toCompare = this.list[currentIndex+1];

      //Change position
      if (this.testLeft.test(base, toCompare)) {
        this.list[currentIndex] = toCompare;
        this.list[currentIndex+1] = base;
      }

      currentIndex++;
    }

    //Goto next position.
    final int next = searchUntil-1;
    if (next>0) {
      this.sort(next);
    }

    return this.list;
  }
}
