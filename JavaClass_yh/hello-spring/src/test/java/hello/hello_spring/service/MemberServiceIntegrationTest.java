package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
//보통 intTest라고 적기도 하고 안적기도 한다.

@SpringBootTest //부트 테스트
@Transactional
class MemberServiceIntegrationTest {

    //실제 구현 클래스는 생성자 Injection이 좋지만, 테스트는 굳이.. ㅎㅎ AutoWired로 편하게 사용한다./

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
git

    @Test
    void 회원가입() {
        //given -> when -> then 문법

        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외_검사(){
         //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring2");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 있는 회원 입니다");

/*        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 있는 회원 입니다");
        }*/


        //then
    }
    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}