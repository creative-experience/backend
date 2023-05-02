package br.com.finalproject.financeandstock.application;

import br.com.finalproject.financeandstock.domain.model.UserModel;
import br.com.finalproject.financeandstock.framework.adapter.out.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final CustomerRepository customerRepository;

    public UserModel getAuth(Authentication authentication) {
        List<UserModel> userModels = customerRepository
                .findByEmail(authentication.getName());
        if (!userModels.isEmpty())
            return userModels.get(0);
        return null;
    }

}
