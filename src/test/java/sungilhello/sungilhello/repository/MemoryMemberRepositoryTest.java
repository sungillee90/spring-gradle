package sungilhello.sungilhello.repository;
// No need to be "public" bc we are not using it from other classes/packages
// public class MemoryMemberRepositoryTest {
// }

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import sungilhello.sungilhello.domain.Member;

class MemoryMemberRepositoryTest {

    MemberRepository repo = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Spring");
        
        repo.save(member);
        
        Member result = repo.findById(member.getId()).get();
//        Assertions.assertEquals(member, result);
        Assertions.assertThat(member).isEqualTo(result);
        // make sure both member id and result id are the same
        System.out.println("(result == member) = " + (result == member));
    }

}