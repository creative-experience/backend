package br.com.finalproject.financeandstock.framework.adapter.in;

import br.com.finalproject.financeandstock.application.LoginService;
import br.com.finalproject.financeandstock.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/user")
    public UserModel getUserDetailsAfterLogin(Authentication authentication) {
        return loginService.getAuth(authentication);
    }

}
