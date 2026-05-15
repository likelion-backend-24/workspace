package oopexam.dip;


public class STV implements TV{
    boolean power;
    int volume;

    public STV(){
        this.power = false;
        this.volume=0;
    }

    @Override
    public void turnOn() {
        this.power = true;
        System.out.println("STV is turned on");
    }

    @Override
    public void turnOff() {
        this.power = false;
        System.out.println("STV is turned off");
    }

    @Override
    public void volumeUP() {
        if(power){
            volume++;
            System.out.println("STV volume up");
        }

    }

    @Override
    public void volumeDOWN() {
        if(power){
            volume--;
            System.out.println("STV volume down");
        }
    }

    public void on(){

    }

    public void off(){
        this.power = false;
    }

    public void volumeUp(){
        if(power){
            volume++;
        }
    }

    public void volumeDown(){

    }
}
