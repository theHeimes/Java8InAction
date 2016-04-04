package lambdasinaction.chap3;

public class Runners {
	static Runnable r1 = () -> System.out.println("Hello Lambda World");
	static Runnable r2 = new Runnable() {
		
		@Override
		public void run() {
			System.out.println("Hello anonymus class World");
		}
	};
	
	public static void process(Runnable r){
		r.run();
	}
	public static void main(String[] args) {
		process(r1);
		process(r2);
		process(() -> System.out.println("Hello from anonymus Lambda"));
	}
}
