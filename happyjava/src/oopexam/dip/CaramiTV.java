package oopexam.dip;

public class CaramiTV implements TV{
    //전원을 켜다
    //전원을 끄다
    //소리를 키우다
    //소리를 줄이다.
    public void turnOn(){
        System.out.println("Carami TV turned on");
    }
    public void turnOff(){
        System.out.println("Carami TV turned off");
    }
    public void volumeUP(){
        System.out.println("Carami TV volume up");
    }

    public void volumeDOWN(){
        System.out.println("Carami TV volume down");
    }
}
