package org.example.singleton;

public class LazySingletonMain {
    public static void main(String[] args) {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        LazySingleton lazySingleton1 = LazySingleton.getInstance();

        if(lazySingleton == lazySingleton1){
            System.out.println("lazySingleton == lazySingleton1");
        }

        lazySingleton.showMessage();
    }
}
