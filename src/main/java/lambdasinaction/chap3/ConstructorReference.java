package lambdasinaction.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReference {

  public static void main(String[] args) {
    
    Supplier<Apple> c1 = Apple::new;
    Apple a1 = c1.get();
    System.out.println("Constructing an apple with 'Supplier' interface");
    System.out.println(a1);
    
    Function<Integer, Apple> c2 = Apple::new;
    Apple a2 = c2.apply(150);
    System.out.println("Constructing an apple with 'Function' interface");
    System.out.println(a2);
    
    System.out.println("Constructing a apples with 'Function' interface");
    List<Integer> weights = Arrays.asList(140, 130, 125, 165);
    List<Apple> apples = map(weights, Apple::new);
    for(Apple a : apples) {
      System.out.println(a);
    }
    
    System.out.println("Constructing an apple with 'BiFunction' interface");
    BiFunction<Integer, String, Apple> c3 = Apple::new;
    Apple a3 = c3.apply(160, "red");
    System.out.println(a3);
    
  }
  public static List<Apple> map(List<Integer> weights, Function<Integer, Apple> f) {
    List<Apple> result = new ArrayList<>();
    
    for(Integer e : weights) {
      result.add(f.apply(e));
    }
    return result;
  }
}
