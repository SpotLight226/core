package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
    
    // 생성자를 통해 자동 주입 => 인터페이스에만 의존한다!!
    private final MemberRepository memberRepository; // 회원 저장소
    private final DiscountPolicy discountPolicy; // 할인 정책

    // 어느 할인정책이 들어올지 모른다
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // OrderService 는 discountPolicy 에 대한 것은 상관없이 값이 반환되게 되어 있다 => 설계 잘 됨
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 멤버
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인된 가격

        return new Order(memberId, itemName, itemPrice, discountPrice); // 주문을 반환
    }
}
