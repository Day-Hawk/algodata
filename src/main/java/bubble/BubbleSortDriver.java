package bubble;

import static  example.Data.*;




public final class BubbleSortDriver {


  public static void main(String[] args) {
    new BubbleSort<>(randomIntegerArray(5, 100, 50), (integer, integer2) -> integer<integer2)
        .sort();

   new BubbleSort<>( randomIntegerArray(5, 100, 5), (integer, integer2) -> integer>integer2)
       .sort();
  }
}
