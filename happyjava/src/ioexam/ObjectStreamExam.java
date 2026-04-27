package ioexam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamExam {
    public static void main(String[] args) {
//        try(ObjectOutputStream oos = new ObjectOutputStream(
//                new FileOutputStream("friend.txt")
//        )){
//            Friend friend = new Friend("둘리","010-111-2222","like@like.com");
//            oos.writeObject(friend);
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("friend.dat"))){
            Friend friend =(Friend) ois.readObject();
            System.out.println(friend.getName());
            System.out.println(friend.getEmail());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
