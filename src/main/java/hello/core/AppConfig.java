package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//@Bean이 붙은 메서드마다 이미 스프링빈이 존재하면 존재하는 빈을 반환하고, 스프링 빈이 없으면 스플이 빈으로 등록하고 반환하는 코드가 동적으로 만들어짐
// 싱글톤 보장 - Configuration 적용한 Appconfig <- 상속하는 AppConfig AppConfig@CGLIB
@Configuration
public class AppConfig {
    //생성자 주입
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy(); 정률 정책으로 변경
        return new RateDiscountPolicy();
    }
}
