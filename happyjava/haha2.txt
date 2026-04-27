package ioexam;

import java.io.*;
import java.net.URL;

public class IOExam {
    public static void main(String[] args) throws IOException {
        //무엇을 하고 싶은지??
        //키보드로부터 한 줄 씩 입력 받고 싶다.
        //키보드 - System.in  - InputStream
        //한줄씩!! -- BufferedRearder (Reader)
        URL url = new URL("https://docs.oracle.com/javase/8/docs/api/java/lang/System.html");

//        InputStream in = System.in;
//        InputStream in = new FileInputStream("src/ioexam/IOExam.java");
        InputStream in = url.openStream();
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);


//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String msg = null;

        System.out.println("입력하세요::");
        msg = br.readLine();

        System.out.println(msg);

//        한번만 입력받는것이 아니라 여러번 입력 받고 싶다면???

        while ((msg = br.readLine()) != null){
            System.out.println(msg);
        }


        br.close();
        isr.close();
        in.close();
    }
}
