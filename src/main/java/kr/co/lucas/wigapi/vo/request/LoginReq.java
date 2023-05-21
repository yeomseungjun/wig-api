package kr.co.lucas.wigapi.vo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginReq {
    private String id;
    private String pass;
}
