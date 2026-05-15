package oopexam;

interface OrderService {
    void placeOrder(String item);
    void cancelOrder(String orderId);
}

class OnlineOrderService implements OrderService {
    @Override
    public void placeOrder(String item) {
        System.out.println("Order placed: " + item);
    }

    @Override
    public void cancelOrder(String orderId) {
        System.out.println("Order cancelled: " + orderId);
    }
}


// 주문 생성만 필요한 클라이언트
class OrderClient {
    private final OrderService orderService;

    public OrderClient(OrderService orderService) {
        this.orderService = orderService;
    }

    public void createNewOrder() {
        orderService.placeOrder("Book");
    }
}

// 주문 취소만 필요한 클라이언트
class CancelClient {
    private final OrderService orderService;

    public CancelClient(OrderService orderService) {
        this.orderService = orderService;
    }

    public void cancelOrder(String orderId) {
        orderService.cancelOrder(orderId);
    }
}


public class ISPDemo {
    public static void main(String[] args) {
        OnlineOrderService service = new OnlineOrderService();

        OrderClient orderClient = new OrderClient(service);
        orderClient.createNewOrder();

        CancelClient cancelClient = new CancelClient(service);
        cancelClient.cancelOrder("ORD1234");
    }
}
