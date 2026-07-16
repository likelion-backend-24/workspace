package org.example.factory.ex2;

// Product
interface Notification {
    void send(String message);
}

// ConcreteProduct 1
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("이메일 발송: " + message);
    }
}

// ConcreteProduct 2
class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("SMS 발송: " + message);
    }
}

class KAKAONotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("KAKAO 발송: " + message);
    }
}

// Creator (추상 클래스)
abstract class NotificationService {
    // Factory Method - 서브클래스가 구현
    protected abstract Notification createNotification();

    // Template Method - 공통 로직
    public void notifyUser(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}

// ConcreteCreator 1
class EmailNotificationService extends NotificationService {
    @Override
    protected Notification createNotification() {
        return new EmailNotification();
    }
}

// ConcreteCreator 2
class SMSNotificationService extends NotificationService {
    @Override
    protected Notification createNotification() {
        return new SMSNotification();
    }
}

class KAKAONotificationService extends NotificationService {
    @Override
    protected Notification createNotification() {
        return new KAKAONotification();
    }
}


public class Demo {
    public static void main(String[] args) {
        NotificationService emailService = new EmailNotificationService();
        emailService.notifyUser("hello~~");

        NotificationService smsService = new SMSNotificationService();
        smsService.notifyUser("hello");

        NotificationService kakaoService = new KAKAONotificationService();
        kakaoService.notifyUser("hello");


    }
}
