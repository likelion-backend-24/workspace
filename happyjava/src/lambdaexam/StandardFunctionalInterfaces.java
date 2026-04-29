package lambdaexam;

import java.util.function.*;
class CunsumerImpl implements Consumer<String>{
    @Override
    public void accept(String s) {
        System.out.println("ccc::"+s);
    }
}
interface 새{}
class IsEven implements Predicate<Integer>{
    @Override
    public boolean test(Integer integer) {
        return integer % 2 == 0;
    }
}
public class StandardFunctionalInterfaces {


    public static void test2(새 b){

    }

    public static void test(Predicate<Integer> i){

    }

    public static void main(String[] args) {

        test(num->num%2==0);





        test2(new 새(){

        });




        test(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return false;
            }
        });

        test(new IsEven());


        IsEven isEven2 = new IsEven();
        System.out.println( isEven2.test(10)) ;

        // Predicate<T> - 매개변수 하나, boolean 반환
        Predicate<Integer> isEven = num -> num % 2 == 0;

        System.out.println(isEven.test(4)); // true
        System.out.println(isEven.test(5)); // false

        // Function<T, R> - 매개변수 하나, 다른 타입 반환
        Function<String, Integer> stringLength = str -> str.length();
        System.out.println(stringLength.apply("Hello")); // 5

        // Consumer<T> - 매개변수 하나, 반환값 없음
        Consumer<String> printer = str -> System.out.println("출력: " + str);
        printer.accept("람다식 테스트"); // 출력: 람다식 테스트

        // Supplier<T> - 매개변수 없음, 값 반환
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("랜덤 값: " + randomSupplier.get());

        // BinaryOperator<T> - 같은 타입 매개변수 두 개, 같은 타입 반환
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(10, 20)); // 30
    }
}