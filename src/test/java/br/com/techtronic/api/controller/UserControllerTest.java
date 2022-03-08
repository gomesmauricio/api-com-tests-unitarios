package br.com.techtronic.api.controller;

import br.com.techtronic.api.domain.User;
import br.com.techtronic.api.domain.dto.UserDTO;
import br.com.techtronic.api.mother.UserMother;
import br.com.techtronic.api.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {

    private static final Integer ID   = 1;
    public static final int INDEX = 0;
    private static final String NAME  = "Test Silva";
    private static final String EMAIL = "test@mail.com";
    private static final String PASSWORD = "123";

    private final User user                   = UserMother.getUser();
    private final UserDTO userDTO             = UserMother.getUserDTO();

    @InjectMocks
    private UserController controller;

    @Mock
    private UserServiceImpl service;

    @Mock
    private ModelMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}