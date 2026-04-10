package day08;

abstract class Car{
//    public void run(){
//        System.out.println("차가 달리다.");
//    }
    abstract public void run();

    //차를 설명하기 위해서 굉장히 복잡한 것들이 있었어요.
//    많은 속성과,  기능을 갖고 있을거예요!!
}
class Bus extends Car{

    public void run() {
        System.out.println("버스가 달리다.");
    }
}
class Truck extends Car{

    public void run() {
        System.out.println("트럭이 달리다.");
    }
}
public class Exam01 {
    public static void main(String[] args) {
//        Car car = new Car() ;
        Bus bus = new Bus();
        Truck truck = new Truck();
        bus.run();
        truck.run();

        Car car = new Bus();
        Car car2 = new Truck();

        car.run();
        car2.run();
    }
}
