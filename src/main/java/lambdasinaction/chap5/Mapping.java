package lambdasinaction.chap5;

import lambdasinaction.chap4.*;

import java.util.*;
import static java.util.stream.Collectors.toList;
import static lambdasinaction.chap4.Dish.menu;

public class Mapping{

    public static void main(String...args){

        // map
        List<String> dishNames = menu.stream()
                                     .map(Dish::getName)
                                     .collect(toList());
        System.out.println(dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                                         .map(String::length)
                                         //.distinct()
                                         .collect(toList());
        System.out.println(wordLengths);
        
        List<Integer> dishNameLengths = menu.stream()
            .map(Dish::getName)
            .map(String::length)
            .sorted()
            .distinct()
            .collect(toList());
        System.out.printf("\nLengths of dish names: %s\n", dishNameLengths);

        System.out.printf("\nShowing the need for flatMap\n");
        // map
        words.stream()
                 .map(word -> word.split(""))
                 .distinct()
                 .map(c -> c.getClass())
                 .forEach(System.out::println);
        System.out.println("\nTinkering with map:");
        words.stream()
          .map(word -> word.split(""))
          .flatMap(Arrays::stream)
//          .map(c -> c.getClass())
          .distinct()
          .forEach(System.out::println);
        System.out.printf("\nHere it comes\n");
        // flatMap
        words.stream()
                 .flatMap((String line) -> Arrays.stream(line.split("")))
                 .distinct()
                 .forEach(System.out::println);
        
        System.out.println("\nQuiz 5.2:");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        numbers.stream()
          .map(i -> i * i)
          .forEach(System.out::println);

        System.out.println("\nFlat Map combining two lists (Quiz 5.3):");
        // flatMap
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        List<Integer> numbers2 = Arrays.asList(6,7,8);
        List<int[]> pairs =
                        numbers1.stream()
                                .flatMap((Integer i) -> numbers2.stream()
                                                       .map((Integer j) -> new int[]{i, j})
                                 )
                                .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                                .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
        
        System.out.println("\nFlat Map combining two lists (Quiz 5.3) - 2:");
        numbers1 = Arrays.asList(1,2,3,4,5,6);
        List<int[]> pairs2 =
            numbers1.stream()
                    .flatMap((Integer i) -> numbers2.stream()
                                           .map((Integer j) -> new int[]{i, j})
                     )
                    .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                    .collect(toList());
        pairs2.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }
}
