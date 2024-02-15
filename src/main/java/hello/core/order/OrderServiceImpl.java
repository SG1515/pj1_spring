package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

// 주문 서비스 구현체
public class OrderServiceImpl implements OrderService{

    //인터페이스에만 의존하기 때문에 DIP를 지키고 있다.
    private final MemberRepository memberRepository; //final 되어 있으면 생성자 할당 해야함
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy
            discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

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
