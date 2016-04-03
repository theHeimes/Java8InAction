package lambdasinaction.chap1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FilteringApples{

    public static void main(String ... args){

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                                              new Apple(155, "green"),
                                              new Apple(120, "red"),
                                              new Apple(160, "brown"),
                                              new Apple(145, "orange"));
        
        //System.out.println(inventory.sort(comparing(Apple::getWeight)));

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println("Green apples");
        System.out.println(greenApples);
        
        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println("\nHeavy apples");
        System.out.println(heavyApples);
        
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println("\nGreen apples");
        System.out.println(greenApples2);
        
        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println("\nHeavy apples");
        System.out.println(heavyApples2);
        
        // []
        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || 
                                                                       "brown".equals(a.getColor()));
        System.out.println("\nWeird apples");
        System.out.println(weirdApples);
        
        List<Apple> orangeApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || 
                "orange".equals(a.getColor()));
        System.out.println("\nOrange apples");
		System.out.println(orangeApples);
		
		List<Apple> notGreenApples = filterApples(inventory, (Apple a) -> !"green". equals(a.getColor()));
		System.out.println("\nNot green apples");
		System.out.println(notGreenApples);
		
		// Using the stream API
		System.out.println("\nNot green apples from stream");
		System.out.println(inventory.stream()
				.filter((Apple a) -> !"green".equals(a.getColor()))
				.collect(Collectors.toList()));
		// Filter with the parallel Stream
		System.out.println("\nGreen apples from parallel stream");
		System.out.println(inventory.parallelStream()
				.filter((Apple a) -> "green".equals(a.getColor()))
				.collect(Collectors.toList()));
        
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        for (File f : hiddenFiles) {
        	System.out.println(f.getAbsolutePath());
        }
    }

    
	public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor()); 
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }       

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                   "color='" + color + '\'' +
                   ", weight=" + weight +
                   '}';
        }
    }

}
