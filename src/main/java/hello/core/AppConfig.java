package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 애플리케이션 전체를 설정하고 구성하는 클래스
//생성자 주입
public class AppConfig {

    // MemberService
    public MemberService memberService(){
        //  MemberServiceImpl 를 생성하여 반환
        //  MemoryMemberRepository 를 주입해준다
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    
    // 생성자를 통해 주입
    public OrderService orderService() {
        //
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
