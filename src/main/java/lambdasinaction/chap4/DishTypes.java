package lambdasinaction.chap4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static java.util.stream.Collectors.groupingBy;

import lambdasinaction.chap4.Dish.Type;

public class DishTypes {
  
  public static void main(String[] args) {
    
    Map<Dish.Type, List<Dish>> dishesByType = new HashMap<>();
    // initialize dishesByType
    for (Type t : Type.values()) {
      dishesByType.put(t, new ArrayList<Dish>());
    }
    for (Dish d : Dish.menu) {
      List<Dish> l = dishesByType.get(d.getType());
      l.add(d);
      dishesByType.put(d.getType(), l);
    }
    
    System.out.println("Menu by types in Java 7");
    Set<Type> keys = dishesByType.keySet();
    for (Type key : keys) {
      System.out.printf("%-6s=%s\n", key, dishesByType.get(key));
    }
    
    // And just for fun now in Java 8 style
    System.out.println("\nMenu by types in Java 8");
    
    Map<Dish.Type, List<Dish>> dishesByType8 =
        Dish.menu.parallelStream().collect(groupingBy(Dish::getType));
    
    keys = dishesByType8.keySet();
    for (Type key : keys) {
      System.out.printf("%-6s=%s\n", key, dishesByType8.get(key));
    }
     
  }
}
