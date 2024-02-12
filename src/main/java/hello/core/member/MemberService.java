package hello.core.member;

import java.lang.reflect.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
