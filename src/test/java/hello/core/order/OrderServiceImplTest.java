package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    @Test
    public void createOrder() throws Exception {
        //생성자 주입방식으로 테스트 하는 것이 좋다.
        Member member = new Member(1L, "김길동", Grade.VIP );
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(member);
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        orderService.createOrder(1L,"itemA", 10000);
    }
}