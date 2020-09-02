package sungilhello.sungilhello.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sungilhello.sungilhello.domain.Member;
import sungilhello.sungilhello.repository.MemberRepository;
import sungilhello.sungilhello.repository.MemoryMemberRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository repo;

    // Dependency Injection
    @BeforeEach
    public void beforeEach() {
        repo = new MemoryMemberRepository();
        memberService = new MemberService(repo);
    }

    @AfterEach
    public void afterEach() {
        repo.clearStore();
    }


    @Test
    void join() {
        // given
        Member m1 = new Member();
        m1.setName("hello");
        // when
        Long savedId = memberService.join(m1);
        // then
        Member findOneMember = memberService.findOne(savedId).get();
        assertThat(m1.getName()).isEqualTo(findOneMember.getName());
    }

    @Test
    public void exceptionDuplicateMember() {
        // given
        Member m1 = new Member();
        m1.setName("spring");

        Member m2 = new Member();
        m2.setName("spring");

        // when
        memberService.join(m1);
        assertThrows(IllegalStateException.class, () -> memberService.join(m2));
//        try {
//            memberService.join(m2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("Existing member name.");
//        }


        // then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}