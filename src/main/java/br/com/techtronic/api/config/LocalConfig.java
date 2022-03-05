package br.com.techtronic.api.config;

import br.com.techtronic.api.domain.User;
import br.com.techtronic.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@AllArgsConstructor
@Configuration
@Profile("local")
public class LocalConfig {

    private UserRepository userRepository;

    @Bean
    public void startDB(){
        User u1 = new User(null, "Mauricio", "mauricio@mail.com", "123");
        User u2 = new User(null, "Rafaela", "rafa@mail.com", "123");

        userRepository.saveAll(List.of(u1,u2));
    }
}
