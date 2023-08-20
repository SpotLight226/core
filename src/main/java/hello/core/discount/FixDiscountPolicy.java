package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

// 정액 할인 정책 구현체
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        // Enum 타입은 ==
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount; // 1000 원 리턴
        } else {
            return 0;
        }
    }
}
