package lambdaexam;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

class Calculator2{
    public int plus(int i, int j){
        return i+j;
    }
}
public class MethodReferenceExample {
    public static void main(String[] args) {

        Calculator2 calc = new Calculator2();
        calc.plus(1,2);

        calc.plus(5,3);
//        calc.plus(1,"test");




        List<String> names = Arrays.asList("alice", "bob", "charlie", "david");

        names.forEach(n->System.out.println("name :: "+n));

        names.forEach(System.out::println); //좀 더 간편하게 사용하주는 약속..   name -> System.out.println(name);

        names.stream()
                .map(String::toUpperCase) //s -> s.toUpperCase()
                .forEach(System.out::println);

        Supplier<List<String>> listSupplier = ArrayList::new; // ()  -> new ArrayList<>();

        String prefix = "Name : ";
        Function<String,String> addPrefix = prefix::concat;//(str)->prefix.concat(str);


        names.stream()
                .map(addPrefix)
                .forEach(System.out::println);



        names.stream()
                .map( prefix::concat)
                .forEach(System.out::println);
    }
}
