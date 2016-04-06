package lambdasinaction.chap3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ConstructorMap {

  static Map<String, Function<Integer, Fruit>> map = new HashMap<>();
  static {
    map.put("apple", Apple::new);
    map.put("banana", Banana::new);
    map.put("orange", Orange::new);
  }
  
  public static Fruit giveMeFruit(String fruit, Integer weight) {
    return map.get(fruit.toLowerCase()).apply(weight); 
  }
  
  public static void main(String[] args) {
    System.out.println(giveMeFruit("Banana", 280));
    System.out.println(giveMeFruit("Banana", 160));
    System.out.println(giveMeFruit("Orange", 280));
    System.out.println(giveMeFruit("Apple", 140));
  }
}
