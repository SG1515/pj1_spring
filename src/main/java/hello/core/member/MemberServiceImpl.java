package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//메모리 버전 구현체
@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository; //인터페이스만 있음 (추상화만 의존)
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public void join(Member member) {
        // 호출하면 MemoryMemberRepository()에 있는 override된 save를 호출
        memberRepository.save(member);
    }
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
