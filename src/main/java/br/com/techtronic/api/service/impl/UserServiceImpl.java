package br.com.techtronic.api.service.impl;

import br.com.techtronic.api.domain.User;
import br.com.techtronic.api.repository.UserRepository;
import br.com.techtronic.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElse(null);
    }
}
