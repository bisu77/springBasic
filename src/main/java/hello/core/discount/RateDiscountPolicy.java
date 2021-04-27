package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    @Override
    public int discount(Member member, int itemPrice) {
        if(member.getGrade() == Grade.VIP){
            return itemPrice * 10 / 100;
        }else{
            return 0;
        }
    }
}
