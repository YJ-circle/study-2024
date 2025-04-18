package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */

    public Long join(Member member) {
        //같은 이름이 있는 중복 회원X
        //증복회원 검증
        vaildateDuplicatMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void vaildateDuplicatMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 있는 회원 입니다");
                        });
    }

    /**
     * 전체 회원 조회
     */

    public List<Member> findMember(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
