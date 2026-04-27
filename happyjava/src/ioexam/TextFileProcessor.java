package ioexam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class TextFileProcessor {
    public static void main(String[] args) throws  Exception{
        //목적!!
        //뭐하고 싶은거지??
        //input.txt 파일에서 읽어서 output.txt 파일에 쓰고 싶어요.
//        쓸때 줄 번호를 추가해서 쓰고 싶어요.
//        줄 번호를 쓴다는 것은 한 줄씩 읽어서 써야된다는 뜻!!

        BufferedReader br = new BufferedReader(new FileReader("ioexam.txt"));
        PrintWriter pw = new PrintWriter("output.txt");

        String line = null;
        int lineNumber = 1;

        while ((line = br.readLine()) != null){
            pw.println(lineNumber++ +": "+ line);
        }

        pw.close();

    }
}
