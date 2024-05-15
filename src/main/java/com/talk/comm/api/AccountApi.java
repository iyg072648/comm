package com.talk.comm.api;

import com.talk.comm.aop.annotation.ValidAspect;
import com.talk.comm.dto.CMRespDto;
import com.talk.comm.entity.UserMst;
import com.talk.comm.service.AccountService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@Api(tags = {"Accout Rest API Controller"})
@RestController
@RequestMapping("/api/account")
public class AccountApi {

    @Autowired
    private AccountService accountService;
    
    @ApiModelProperty(value = "회원가입", notes = "회원가입 요청 메소드")
    @ValidAspect
    @PostMapping("/register")
    public ResponseEntity<? extends CMRespDto<? extends UserMst>> register(@RequestBody @Valid UserMst userMst, BindingResult bindingResult) {

        accountService.duplicateUsername(userMst.getUsername());
        accountService.compareToPassword(userMst.getPassword(), userMst.getRepassword());

        UserMst user = accountService.registerUser(userMst);

        return ResponseEntity
                .created(URI.create("/api/account/user/" + user.getUserId()))
                .body(new CMRespDto<>("Create a new User", user));
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<? extends CMRespDto<? extends UserMst>> getUser(
        @PathVariable int userId){
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>("Success", accountService.getUser(userId)));
    }
}
