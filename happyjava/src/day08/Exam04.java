package day08;
//인터페이스는 기능을 모아둔 것!!
interface 나는것{
    public void 날다();
}
class 비행기 implements 나는것{
    public void 날다(){
        System.out.println("비행기가 날아요.");
    }
}
class 헬리콥터 implements 나는것{
    String name;
    public void 태우다(){

    }
    public void 날다(){
        System.out.println("헬리콥터가 날아요.");
    }
}
class 나비 implements 나는것{
    public void 날다(){
        System.out.println("나비가 날아요.");
    }

}
public class Exam04 {
    public static void main(String[] args) {
        나는것 a = new 헬리콥터();
        a.날다();

    }
}
