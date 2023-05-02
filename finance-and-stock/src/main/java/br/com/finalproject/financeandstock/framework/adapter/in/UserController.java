package br.com.finalproject.financeandstock.framework.adapter.in;

import br.com.finalproject.financeandstock.application.UserService;
import br.com.finalproject.financeandstock.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserModel userModel) {
        try {
            userService.getRegisterUser(userModel);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Given user details are successfully registered");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred due to " + e.getMessage());
        }

    }

    @GetMapping("/list-user")
    public Page<UserModel> listUser(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        var sort = Sort.by(Sort.Direction.ASC, "name");
        var pageRequest = PageRequest.of(page, size, sort);
        return userService.findAll(pageRequest);

    }

}
