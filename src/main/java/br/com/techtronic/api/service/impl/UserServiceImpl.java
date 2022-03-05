package br.com.techtronic.api.service.impl;

import br.com.techtronic.api.domain.User;
import br.com.techtronic.api.repository.UserRepository;
import br.com.techtronic.api.service.UserService;
import br.com.techtronic.api.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
