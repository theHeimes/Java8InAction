package lambdasinaction.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import lambdasinaction.chap3.Sorting.Apple;

public class PredicateComposition {
  public static void main(String[] args) {
    List<Apple> inventory = new ArrayList<>();
    inventory.addAll(Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red")));

    
    System.out.println("\nComposing Predicates");
    Predicate<Apple> redApple = (a -> "red".equalsIgnoreCase(a.getColor()));
    Predicate<Apple> notRedApple = redApple.negate();
    Predicate<Apple> redAndHeavy = redApple.and( a -> a.getWeight() > 150);
    Predicate<Apple> redAndHeavyOrGreen = redAndHeavy.or( a -> "green".equalsIgnoreCase(a.getColor()));
    Predicate<Apple> redOrGreenAndHeavy = 
        redApple.or(a -> "green".equalsIgnoreCase(a.getColor()))
        .and(a -> a.getWeight() > 150);
        
    inventory.add(new Apple(155, "red"));
    
    System.out.println("Filter with predicate 'redApple'");
    System.out.println(filter(inventory, redApple));
    System.out.println("Filter with predicate 'notRedApple'");
    System.out.println(filter(inventory, notRedApple));
    System.out.println("Filter with predicate 'redAndHeavy'");
    System.out.println(filter(inventory, redAndHeavy));
    System.out.println("Filter with predicate 'redAndHeavyOrGreen'");
    System.out.println(filter(inventory, redAndHeavyOrGreen));
    System.out.println("Filter with predicate 'redOrGreenAndHeavy'");
    System.out.println(filter(inventory, redOrGreenAndHeavy));
  }
  
  public static <T> List<T> filter(List<T> inventory, Predicate<T> p){
    List<T> result = new ArrayList<>();
    for(T apple : inventory){
      if(p.test(apple)){
        result.add(apple);
      }
    }
    return result;
  }


}
