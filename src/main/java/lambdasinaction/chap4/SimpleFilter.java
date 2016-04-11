package lambdasinaction.chap4;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class SimpleFilter {
  public static void main(String[] args) {
    List<Dish> vegieDishes = Dish.menu.stream()
        .filter(Dish::isVegetarian)
        .collect(toList());
    System.out.printf("Veggie Dishes: %s", vegieDishes);
  }
}
