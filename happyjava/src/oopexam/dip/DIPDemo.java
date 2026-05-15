package oopexam.dip;

// DIP 예제
interface MessageService {
    void sendMessage(String msg);
}

class EmailService implements MessageService {
    @Override
    public void sendMessage(String msg) {
        System.out.println("Email: " + msg);
    }
}

class SmsService implements MessageService {
    @Override
    public void sendMessage(String msg) {
        System.out.println("SMS: " + msg);
    }
}

class MessageSender {
    private final MessageService messageService;

    public MessageSender(MessageService messageService) {
        this.messageService = messageService;
    }

    public void send(String msg) {
        messageService.sendMessage(msg);
    }

//    private EmailService emailService = new EmailService();
//    private SmsService smsService = new SmsService();
//    public void sendMessage(String msg) {
//        emailService.sendMessage(msg);
//        smsService.sendMessage(msg);
//    }
}

public class DIPDemo {
    public static void main(String[] args) {
        MessageSender emailSender = new MessageSender(new EmailService());
        emailSender.send("Hello via Email!");

        MessageSender smsSender = new MessageSender(new SmsService());
        smsSender.send("Hello via SMS!");

//        MessageSender sender = new MessageSender();
//        sender.sendMessage("Hello World");
    }
}