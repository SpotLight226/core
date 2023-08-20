package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 회원 저장소
    // 다형성으로 구현체의 메서드가 호출된다
    // 이제 MemoryMemberRepository 에 대한 코드가 없다 => 인터페이스에만 의존
    private final MemberRepository memberRepository;

    // MemberRepository 생성자
    // 생성자로 들어와서 memberRepository 에 할당된다
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }
    
    // 회원 찾기
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
