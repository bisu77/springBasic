package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class AutoAppConfigTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    @Test
    void basicScan(){
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    void orderServiceTest(){
        Member member = new Member(1L,"윤경준", Grade.VIP);
        MemberService memberService = ac.getBean("memberServiceImpl", MemberService.class);
        memberService.join(member);

        OrderServiceImpl orderService1 = ac.getBean("orderServiceImpl", OrderServiceImpl.class);
        Member findMember = orderService1.getMemberRepository().findMember(1L);
        System.out.println("findMember = " + findMember.getName());

        Assertions.assertThat(findMember.getName()).isEqualTo("윤경준");
    }

}