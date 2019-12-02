package design_pattern.singleton;

public class DBSingleton {
	private static DBSingleton instance = new DBSingleton();
	private DBSingleton() {}
	
	public DBSingleton getIntance() {
		return instance;
	}

}
