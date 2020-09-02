package sungilhello.sungilhello.service;

import sungilhello.sungilhello.domain.Member;
import sungilhello.sungilhello.repository.MemberRepository;
import sungilhello.sungilhello.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
// cmd + shift + t == Create Test
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * For sign up membership
     * Logic: There should be no same (duplicate) name as a member.
     */
    public Long join(Member member) {

//        Optional<Member> result = memberRepository.findByName(member.getName()); // cmd + opt + v

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
            throw new IllegalThreadStateException("Existing member name.");
            });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
