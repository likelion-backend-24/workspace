package ioexam;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputExam {
    public static void main(String[] args) throws Exception{
        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(new FileInputStream("data.txt"))
        );

        System.out.println(dis.readDouble());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readInt());

        dis.close();
    }
}
