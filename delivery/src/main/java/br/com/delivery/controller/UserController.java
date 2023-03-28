package br.com.delivery.controller;

import br.com.delivery.model.UserModel;
import br.com.delivery.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping
    public List<UserModel> getAllUsers(){
        List<UserModel> Users =  userService.findAll();
        return Users;
    }

    @GetMapping("/{User_id}")
    public UserModel getByUserId(@PathVariable UUID uuid){
        UserModel user = userService.getById(uuid);
        return user;
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody UserModel userModel){
        try {
            userService.saveUser(userModel);
        }
        catch (Exception e){
            throw e;
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserModel> login(@RequestBody UserModel userModel){
        Optional<UserModel> model = userService.login(userModel);

      return   model == null ?
              ResponseEntity.status(HttpStatus.UNAUTHORIZED).build() :
              ResponseEntity.ok(userModel);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam UUID uuid){
        userService.deleteUser(uuid);
    }
}
