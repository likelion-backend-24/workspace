package day03;

public class TernaryExample {
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);

        String result = (number % 2 == 0) ? "짝수":"홀수";

        System.out.println(result);


        if(number%2==0){
            result = "짝수";
        }else{
            result = "홀수";
        }


        int result2 = (number % 2 == 0) ? 0:1;


        boolean result3 = (number % 2 == 0) ? true:false;

        char result4 = (number % 2 == 0) ? 'a':'b';



    }
}
