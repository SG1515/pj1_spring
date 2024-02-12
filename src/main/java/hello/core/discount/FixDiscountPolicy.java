package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

//정액 할인 정책 구현체
public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000;

    //등급이 VIP인 member에게만
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){ //enum type ==
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
