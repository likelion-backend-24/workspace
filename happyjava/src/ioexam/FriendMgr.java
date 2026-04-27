package ioexam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FriendMgr {
    //친구의 이름, 전화번호, 이메일 주소를 입력 받아서 파일에 저장하려고 해요.
    //친구 5명만 저장하는 프로그램을 만들어 볼까요??
    public static void addFriend(){
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter pw = new PrintWriter("myFriendInfo.txt");
        ){
            String name, phone, email;
            for(int i = 0; i < 5; i++){
                System.out.println("이름을 입력하세요.  ");
                name = br.readLine();
                System.out.println("전화번호를 입력하세요. ");
                phone = br.readLine();
                System.out.println("이메일을 입력하세요.");
                email = br.readLine();

                pw.println(name + " "+phone + " "+ email);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
//        addFriend();
//
        List<Friend> friends = new ArrayList<>();
    //파일로 부터 친구 정보를 읽어온다면??
        try(BufferedReader br = new BufferedReader(new FileReader("myFriendInfo.txt"))){
//            System.out.println(br.readLine());
            String friendInfo = null;
            while ((friendInfo=br.readLine())!=null){
               String[] info = friendInfo.split(" ");
               Friend friend = new Friend(info[0],info[1],info[2]);
               friends.add(friend);
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("================친구목록보기=================");
        for (Friend friend : friends){
            System.out.println(friend);
        }
    }

}
