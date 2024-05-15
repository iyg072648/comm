package com.talk.comm.service;

import com.talk.comm.entity.UserMst;
import com.talk.comm.exception.CustomValidationException;
import com.talk.comm.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    //비밀번호 생성
    public UserMst registerUser(UserMst userMst){
        userMst.setPassword(new BCryptPasswordEncoder().encode(userMst.getPassword()));
        accountRepository.saveUser(userMst);
        accountRepository.saveRole(userMst);
        return userMst;
    }
    
    //사용자 이름 중복 체크
    public void duplicateUsername(String username){
        UserMst user = accountRepository.findUserByUsername(username);
        if(user != null){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("username", "이미 존재하는 사용자 이름입니다.");

            throw new CustomValidationException(errorMap);
        }
    }

    //비밀번호 재확인
    public void compareToPassword(String password, String repassword){
        if(!password.equals(repassword)){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("repassword", "비밀번호가 일치하지 않습니다.");

            throw new CustomValidationException(errorMap);
        }
    }

    //userId 받아오기
    public UserMst getUser(int userId){
        return accountRepository.findUserByUserId(userId);
    }
}
