package hello.core.order;

public interface OrderService {

    // 주문
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
