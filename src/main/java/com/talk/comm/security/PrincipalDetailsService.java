package com.talk.comm.security;

import com.talk.comm.aop.annotation.ParamsAspect;
import com.talk.comm.entity.UserMst;
import com.talk.comm.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @ParamsAspect
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //해당 username이 DB(user_mst table)에 존재 하는지 확인!
        UserMst user = accountRepository.findUserByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("회원정보를 확인 할 수 없음.");
        }
        return new PrincipalDetails(user);
    }
}
