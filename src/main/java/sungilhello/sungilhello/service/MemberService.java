package sungilhello.sungilhello.service;

import sungilhello.sungilhello.domain.Member;
import sungilhello.sungilhello.repository.MemberRepository;
import sungilhello.sungilhello.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * For sign up membership
     * Logic: There should be no same (duplicate) name as a member.
     */
    public Long join(Member member) {

//        Optional<Member> result = memberRepository.findByName(member.getName()); // cmd + opt + v
        result.ifPresent(m -> {
            throw new IllegalThreadStateException("Existing member name.");
        });

        memberRepository.save(member);
        return member.getId();
    }

}
