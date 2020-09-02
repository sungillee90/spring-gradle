package sungilhello.sungilhello.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import sungilhello.sungilhello.domain.Member;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();


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
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}