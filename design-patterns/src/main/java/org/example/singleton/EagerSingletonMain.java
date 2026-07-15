package org.example.singleton;

public class EagerSingletonMain {
    public static void main(String[] args) {
        EagerSingleton e1 = EagerSingleton.getInstance();
        EagerSingleton e2 = EagerSingleton.getInstance();

        if(e1 == e2){
            System.out.println("같은객체!!");
        }
    }
}
