package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

// 주문 서비스 구현체
public class OrderServiceImpl implements OrderService{


    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        // 멤버 찾기
        Member member = memberRepository.findById(memberId);
        //할인에 대한 것은 discountPolicy가 함 단일 책임 원칙 잘 따름
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //최종 할인 금액 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
