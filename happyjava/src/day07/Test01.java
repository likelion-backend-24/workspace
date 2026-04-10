package day07;

class Parent1{
    int i = 10;
    Parent1(){
        System.out.println("Parent1() 실행!!");
    }
    Parent1(int i){
        System.out.println("Parent1(int ) 실행!!");
    }

    public void 음악을듣다(){
        System.out.println("CD 플레이어를 이용해서 음악을 듣는다.");
    }
}
class Child1 extends Parent1{
    //필드가 오버라이딩됨.
    int i = 20;
    int j = 30;

    Child1(){
        super(10);
        System.out.println("Child1() 실행!!");
    }

    //메소드 오버라이딩
    public void 음악을듣다(){
        System.out.println("유튜브를 이용해서 음악을 듣는다.");
    }
}
public class Test01 {
    public static void main(String[] args) {
        Child1 c = new Child1();
        c.i = 10;


// 1.메서드는 오버라이딩되면 무조건 자식이 구현한 메서드 이용.
                c.음악을듣다();

        Parent1 p = new Parent1();
        p.음악을듣다();

// 2.부모는(조상) 자식(자손)을 가리킬 수 있다.  (타입이 될 수 있다.)
        Parent1 p2 = new Child1();
        Object obj = p2;
        Object obj2 = c;


// 3        Child1 c2 = new Parent1(); 자식타입으로 부모를 가리키는 것은 불가능!!

// 4  필드는 오버라이딩되면 타입을 따른다.

        Parent1 pc = new Child1();
        System.out.println(pc.i);

        int j = ((Child1)pc).j;
        System.out.println(((Child1)pc).j);

        Child1 cc = new Child1();
        System.out.println(cc.j);



    }
}
