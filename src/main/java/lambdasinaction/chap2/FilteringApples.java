package lambdasinaction.chap2;

import java.util.*;

public class FilteringApples{

	public static void main(String ... args){

		List<Apple> inventory = Arrays.asList(new Apple(80,"green"), 
				new Apple(155, "green"),
				new Apple(95, "red"),
				new Apple(157, "red"),
				new Apple(120, "red"));	

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples = filterApplesByColor(inventory, "green");
		System.out.println(greenApples);

		// [Apple{color='red', weight=120}]
		List<Apple> redApples = filterApplesByColor(inventory, "red");
		System.out.println(redApples);

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
		System.out.println(greenApples2);

		// [Apple{color='green', weight=155}]
		List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
		System.out.println(heavyApples);

		// []
		List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
		System.out.println(redAndHeavyApples);

		// [Apple{color='red', weight=120}]
		List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
			public boolean test(Apple a){
				return a.getColor().equals("red"); 
			}
		});
		System.out.println(redApples2);
		
		prettyPrintApple(inventory, new PrintWeightPredicate());
		prettyPrintApple(inventory, new PrintFancyPredicate());
		
		List<Apple> result = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
		System.out.println("\nLambda filtered apples");
		prettyPrintApple(result, new PrintFancyPredicate());

		System.out.println("\nUsing Predicate interface");
		prettyPrintApple(filterList(inventory, (Apple apple) -> "green".equals(apple.getColor())), 
				new PrintFancyPredicate());
		List<Integer> numbers = new ArrayList<>();
		for(int i = 0; i < 20; i++){
			numbers.add(new Integer(i));
		}
		List<Integer> evenNumbers = filterList(numbers, (Integer i) -> i % 2 == 0);
		for(Integer i : evenNumbers) {
			System.out.print(i.toString() + " ");
		}
		
		inventory.sort(new Comparator<Apple>() {
			public int compare(Apple a1, Apple a2){
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		System.out.println("\nSorted apples by weight");
		prettyPrintApple(inventory, new PrintFancyPredicate());
		
		System.out.println("\nSorted apples by weight desc with lambda");
		inventory.sort((Apple a1, Apple a2) -> a2.getWeight().compareTo(a1.getWeight()));
		prettyPrintApple(inventory, new PrintFancyPredicate());
	}

	public static List<Apple> filterGreenApples(List<Apple> inventory){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if("green".equals(apple.getColor())){
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if(apple.getColor().equals(color)){
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if(apple.getWeight() > weight){
				result.add(apple);
			}
		}
		return result;
	}


	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}
	
	public static void prettyPrintApple(List<Apple> inventory, PrintPredicate p){
		for(Apple apple : inventory){
			System.out.println(p.toString(apple));
		}
	}

	interface PrintPredicate{
		public String toString(Apple a);
	}
	
	static class PrintWeightPredicate implements PrintPredicate {
		public String toString(Apple apple){
			return "An apple of " + apple.getWeight() + " weight.";
		}
	}
	
	static class PrintFancyPredicate implements PrintPredicate {
		public String toString(Apple apple){
			return "An apple of " + apple.getWeight() + " weight, which is considered a " +
					(apple.getWeight() > 150 ? "heavy" : "light") + " apple" +
					" and of " + apple.getColor() + " color.";
		}
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
	
	interface ApplePredicate{
		public boolean test(Apple a);
	}

	static class AppleWeightPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return apple.getWeight() > 150; 
		}
	}
	static class AppleColorPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return "green".equals(apple.getColor());
		}
	}

	static class AppleRedAndHeavyPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return "red".equals(apple.getColor()) 
					&& apple.getWeight() > 150; 
		}
	}
	
	interface Predicate<T> {
		boolean test(T t);
	}
	public static <T> List<T> filterList(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for(T e : list ) {
			if (p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}
}