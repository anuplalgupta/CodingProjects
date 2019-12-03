package design_pattern.singleton;

public class DBSingletonDemo {

    public static void main(String[] args){
        DBSingleton dbSingletonInstance = DBSingleton.getInstance();
        System.out.println(dbSingletonInstance);

        DBSingleton dbSingletonInstance2 = DBSingleton.getInstance();
        System.out.println(dbSingletonInstance2);

        if(dbSingletonInstance == dbSingletonInstance2) {
            System.out.println("Both instances are same");
        }
    }
}
