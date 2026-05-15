package oopexam.dip;

public class TVUser {
    public static void main(String[] args) {
//        CaramiTV tv = new CaramiTV();

//        tv.turnOn();
//        tv.volumeDOWN();
//        tv.volumeUP();
//        tv.volumeDOWN();
//        tv.turnOff();

//        STV tv = new STV();
//        tv.on();
//        tv.volumeDown();
//        tv.volumeUp();
//        tv.volumeDown();
//        tv.off();

//인터페이스 추가 후 TVUser
//        TV tv = new CaramiTV();
//        TV tv = new STV();
//        tv.turnOn();
//        tv.volumeDOWN();
//        tv.volumeUP();
//        tv.volumeDOWN();
//        tv.turnOff();


//       TVFactory 추가후
        TV tv = TVFactory.getTV(args[0]);
        tv.turnOn();
        tv.volumeDOWN();
        tv.volumeUP();
        tv.volumeDOWN();
        tv.turnOff();


    }
}
