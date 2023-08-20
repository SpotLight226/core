package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
    
    // 컨커런트 HashMap 을 사용한다 => 실무 : 동시성 이슈로 인해
    private static Map<Long, Member> store = new HashMap<>();
    
    // 멤버 저장
    @Override 
    public void save(Member member) {
        store.put(member.getId(), member);
    }
    
    // 멤버 찾기
    @Override
    public Member findById(long memberId) {
        return store.get(memberId);
    }
}
