package com.talk.comm.config;

import com.talk.comm.repository.MemberRepository;
import com.talk.comm.repository.MemoryMemberRepository;
import com.talk.comm.service.MemberService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
