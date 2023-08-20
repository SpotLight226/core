package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberApp {
    // 인터페이스에만 의존
    // 테스트
    public static void main(String[] args) {
        // AppConfig 를 통해 memberService 를 생성하고 주입한다
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName()); // 가입한 멤버
        System.out.println("find Member = " + findMember.getName()); // 찾은 멤버
    }
}
