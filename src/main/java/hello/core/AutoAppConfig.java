package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( //AppConfig 클래스 컴포넌트를 빼기 위해서 아래처럼
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =  Configuration.class)
)
public class AutoAppConfig {
}
