package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L; // 객체 생성에서 null이 들어갈 수도 있으므로 wrap 타입 사용
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member); // 가입

        Order order = orderService.createOrder(memberId, "itemA", 10000);// 주문 생성

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000); // 1000원 과 맞는지 확인
    }
}
