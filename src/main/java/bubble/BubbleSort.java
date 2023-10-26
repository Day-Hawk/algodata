package bubble;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.function.BiPredicate;


@Log4j2
public final class BubbleSort<ENTITY> {

  /**
   * Store values.
   */
  private final ENTITY[] list;
  /**
   * Compare function
   */
  private final BiPredicate<ENTITY, ENTITY> predicate;
  /**
   * True if sorted.
   */
  private boolean done = false;
  /**
   * Count amount of pos switches
   */
  private int posSwitch = 0;


  public BubbleSort(final ENTITY[] list,
                    final BiPredicate<ENTITY, ENTITY> predicate) {
    this.list = list;
    this.predicate = predicate;
  }

  public ENTITY[] sort() {
    if (this.done) {
      /*Error*/
      log.warn("List already sorted.");
      return this.list;
    }

    final long start = System.currentTimeMillis();
    //Log
    log.info("Bubble sort:\nValues={}", Arrays.toString(this.list));
    final ENTITY[] sort = this.sort(this.list.length);

    //Calculate sort process.
    final long duration = System.currentTimeMillis()-start;
    //Log
    log.info("Bubble sort done:\nSorted values={}, Took={}ms, Position changes={}",
        Arrays.toString(this.list),
        duration,
        this.posSwitch);
    this.done = true;
    return sort;
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
      if (this.predicate.test(base, toCompare)) {
        this.list[currentIndex] = toCompare;
        this.list[currentIndex+1] = base;

        //Log
        log.debug("Changed postion of e1={}, e2={}.", base, toCompare);

        this.posSwitch++;
      } //If false, already sorted -> nothing to do.

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