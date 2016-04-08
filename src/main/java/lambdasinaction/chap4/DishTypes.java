package lambdasinaction.chap4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    
    Set<Type> keys = dishesByType.keySet();
    
    for (Type key : keys) {
      System.out.printf("%-6s=%s\n", key, dishesByType.get(key));
    }
  }
}
