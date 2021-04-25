package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApplication {
    public static void main(String[] args) {
        Member member = new Member(1L, "hello", Grade.VIP);
        MemberService memberService = new MemberServiceImpl();
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
