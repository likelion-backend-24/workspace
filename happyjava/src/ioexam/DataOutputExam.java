package ioexam;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputExam {
    public static void main(String[] args) throws Exception{
//        파일에다가 데이터 타입으로 쓰고 싶다.
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("data.txt")));

        dos.writeDouble(1.1);
        dos.writeBoolean(true);
        dos.writeInt(10);

        dos.close();
    }
}
