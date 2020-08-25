package design_pattern.singleton;

public class DBSingleton {
	private static volatile DBSingleton instance = null;
	private DBSingleton() {
		if(instance != null){
			throw new RuntimeException("Use getInstance method instead");
		}
	}
	
	public static DBSingleton getInstance() {
		if(instance == null){
			synchronized (DBSingleton.class) {
				if (instance == null) {
					instance = new DBSingleton();
				}
		}
		}
		return instance;
	}

}
