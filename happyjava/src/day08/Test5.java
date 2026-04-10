package day08;

abstract class Animal {
    abstract public void makeSound();

    abstract public void move() ;

    //추상 클래스에는 일반적인 필드 메서드 모두 포함 할 수 있어요.
}
class Pig extends Animal{

    @Override
    public void makeSound() {

    }

    @Override
    public void move() {

    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("멍멍!");
    }


    public void move() {
        System.out.println("강아지가 네 발로 뛰어다닙니다.");
    }

    // Dog만의 고유 메소드
    public void wagTail() {
        System.out.println("꼬리를 흔듭니다.");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("야옹~");
    }

    @Override
    public void move() {
        System.out.println("고양이가 살금살금 걷습니다.");
    }

    public void scratch() {
        System.out.println("할퀴기!");
    }
}
public class Test5 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();

       Animal animal = null;
        if(args[0].equals("a"))
            animal = new Cat();
        else
            animal = new Dog();

        animal.makeSound();

//        추상클래스를 인스턴스화 하는것은 불가능!!
//        Animal animal1 = new Animal();

        Animal animal1 = null;

        Animal[] animals = new Animal[3];
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Dog();

        for(Animal animal2 : animals){
            animal2.makeSound();
        }


    }
}
