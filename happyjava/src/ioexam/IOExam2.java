package ioexam;

import java.io.*;

public class IOExam2 {
    public static void main(String[] args) {
//        파일에서 한줄만 읽어서 콘솔에 출력해 보세요.

        try(
                BufferedReader br
                        = new BufferedReader(new FileReader("output.txt"));
                ){
//            System.out.println(br.readLine());
            String msg = null;
            while ((msg = br.readLine()) != null){
                System.out.println(msg);
            }
        }catch (Exception e){

            System.out.println(e.getMessage());
        }

        //키보드로 입력받아서 파일에 저장하세요.

    }
}
