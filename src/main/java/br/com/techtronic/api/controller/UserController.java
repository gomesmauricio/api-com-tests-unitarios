package br.com.techtronic.api.controller;

import br.com.techtronic.api.domain.User;
import br.com.techtronic.api.domain.dto.UserDTO;
import br.com.techtronic.api.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private ModelMapper mapper;
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(userService.findById(id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){

        return ResponseEntity.ok()
                .body(userService.findAll()
                        .stream().map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList()));
    }
}
