package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
)//컴포넌트 스캔 시 @Configuration 어노테이션 붙은 class 제외하도록 처리(기존 코드 AppConfig.java 실행하지 않음)
public class AutoAppConfig {
    @Bean(name="memoryMemberRepository")
    MemoryMemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
