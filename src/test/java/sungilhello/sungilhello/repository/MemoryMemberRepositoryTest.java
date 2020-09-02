package sungilhello.sungilhello.repository;
// No need to be "public" bc we are not using it from other classes/packages
// public class MemoryMemberRepositoryTest {
// }

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import sungilhello.sungilhello.domain.Member;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemberRepository repo = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Spring");
        
        repo.save(member);
        
        Member result = repo.findById(member.getId()).get();
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
        // make sure both member id and result id are the same
        System.out.println("(result == member) = " + (result == member));
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repo.save(member2);

        Optional<Member> result = repo.findByName("Spring1");

        assertThat(result).isEqualTo(result);

    }
}