package day08;
abstract  class 새{
    String name;
    int age;
    abstract public void song();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void 날다(){
        System.out.println("날다");
    }
    public void 먹다(){
        System.out.println("먹다");
    }
}
class 참새 extends 새{
    public void song(){
        System.out.println("짹짹");
    }
}
class 비둘기 extends 새{
    public void song(){
        System.out.println("구구");
    }
}
class 앵무새 extends 새{
    public void song(){
        System.out.println("앵무새가 노래해요.");
    }
}
public class Exam03 {
    public static void main(String[] args) {
//        모든 새들을 노래를 시키려고한다.
        비둘기 b = new 비둘기();
        b.song();
        참새 b2 = new 참새();
        b2.song();

        새 bb = null;
        int sum = 0;
//        b = 새 를 상속받고 있는 클래스는 여기에 다 입장가능!!
//        bb = new 앵무새();
        bb.song();

        //

    }
}
