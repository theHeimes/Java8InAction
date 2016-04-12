package lambdasinaction.chap5;
import static java.util.stream.Collectors.toList;
import static lambdasinaction.chap4.Dish.menu;

import java.util.Arrays;
import java.util.List;

import lambdasinaction.chap4.Dish;

public class Filtering{

    public static void main(String...args){

        // Filtering with predicate
        List<Dish> vegetarianMenu =
            menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        System.out.printf("Vegetarian menu:\n");
        vegetarianMenu.forEach(System.out::println);

        // Filtering unique elements
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        System.out.printf("\nDistinct even numbers:\n");
        System.out.println(numbers);
        numbers.stream()
               .filter(i -> i % 2 == 0)
               .distinct()
               .forEach(System.out::println);
        
        // Truncating a stream
        List<Dish> dishesLimit3 =
            menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());

        System.out.printf("\nLimit dishes:\n");
        dishesLimit3.forEach(System.out::println);

        // Skipping elements
        List<Dish> dishesSkip2 =
            menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());

        System.out.printf("\nSkip dishes:\n");
        dishesSkip2.forEach(System.out::println);
    }
}
