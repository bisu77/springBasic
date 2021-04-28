package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderApplicationTest {
    private MemberService memberService;
    private OrderService orderService;

    @BeforeEach
    void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void order(){
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order itemA = orderService.createOrder(member.getId(), "itemA", 20000);

        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(2000);
    }

}