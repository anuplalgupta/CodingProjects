package design_pattern;

public class SingletonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime singletonRuntime1 = Runtime.getRuntime();
		System.out.println(singletonRuntime1);
		
		Runtime singletonRuntime2 = Runtime.getRuntime();
		System.out.println(singletonRuntime2);
		
		if(singletonRuntime1 == singletonRuntime2) {
			System.out.println("Both objects are same");
		}

	}

}
