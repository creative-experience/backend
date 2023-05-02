package br.com.finalproject.financeandstock.application;

import br.com.finalproject.financeandstock.domain.model.UserModel;
import br.com.finalproject.financeandstock.framework.adapter.out.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public void getRegisterUser(UserModel userModel) {
        String hashPwd = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(hashPwd);
        userModel.setRegistrationDate(LocalDate.now());
        customerRepository.save(userModel);
    }

    public Page<UserModel> findAll(PageRequest pageRequest) {
        return customerRepository.findAll(pageRequest);
    }
}
