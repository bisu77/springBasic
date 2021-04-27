package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;

public class OrderServiceImpl implements OrderService{

    //private DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemNm, int itemPrice) {
        Member findMember = memberRepository.findMember(memberId);
        int discountPrice = discountPolicy.discount(findMember, itemPrice);

        return new Order(findMember.getId(), itemNm, itemPrice, discountPrice);
    }
}
