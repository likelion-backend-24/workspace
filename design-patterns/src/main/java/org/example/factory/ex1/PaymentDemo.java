package org.example.factory.ex1;


// Product 인터페이스
interface PaymentProcessor {
    void processPayment(int amount);
}

// ConcreteProduct 1
class CardPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(int amount) {
        System.out.println("카드 결제: " + amount + "원");
    }
}

// ConcreteProduct 2
class AccountPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(int amount) {
        System.out.println("계좌이체: " + amount + "원");
    }
}

class KakaoPaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment(int amount) {
        System.out.println("kakao 결제 : "+amount + "원");
    }
}


// Simple Factory
class PaymentProcessorFactory {
    public static PaymentProcessor createProcessor(String type) {
        switch (type) {
            case "CARD":
                return new CardPaymentProcessor();
            case "ACCOUNT":
                return new AccountPaymentProcessor();
            case "KAKAO":
                return new KakaoPaymentProcessor();
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentProcessor cardProcess = PaymentProcessorFactory.createProcessor("CARD");

        cardProcess.processPayment(50000);

        PaymentProcessor kakaoProcess = PaymentProcessorFactory.createProcessor("KAKAO");
        kakaoProcess.processPayment(30000);
    }
}
