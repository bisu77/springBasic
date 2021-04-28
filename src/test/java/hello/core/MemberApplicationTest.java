package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberApplicationTest {
    MemberService memberService;

    @Test
    void join(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();

        Member member = new Member(1L, "hello", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        Assertions.assertThat(member).isEqualTo(findMember);
    }
}