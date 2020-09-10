package sungilhello.sungilhello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sungilhello.sungilhello.repository.MemberRepository;
import sungilhello.sungilhello.repository.MemoryMemberRepository;
import sungilhello.sungilhello.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
