package kr.co.lucas.wigapi.controller;

import kr.co.lucas.wigapi.vo.request.LoginReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public boolean login(@RequestBody LoginReq loginReq){
        String id = loginReq.getId();
        String pass = loginReq.getPass();
        if(id.equals("admin") && pass.equals("1234")){
            return true;
        }
        return false;
    }
}