package br.com.delivery.service;

import br.com.delivery.model.UserModel;
import br.com.delivery.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public void saveUser(UserModel userModel) {
        userRepository.save(userModel);
    }

    public void deleteUser(UUID uuid) {
        if (userRepository.existsById(uuid)){
            userRepository.deleteById(uuid);
        }
    }

    public List<UserModel> findAll() {
      return  userRepository.findAll();
    }

    public UserModel getById(UUID uuid) {
        return userRepository.getReferenceById(uuid);
    }

    public Optional<UserModel> login(UserModel userModel) {
         return userRepository.findById(userModel.getId());
    }
}
