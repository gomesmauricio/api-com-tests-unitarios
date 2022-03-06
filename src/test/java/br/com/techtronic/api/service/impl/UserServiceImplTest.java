package br.com.techtronic.api.service.impl;

import br.com.techtronic.api.domain.User;
import br.com.techtronic.api.domain.dto.UserDTO;
import br.com.techtronic.api.mother.UserMother;
import br.com.techtronic.api.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper mapper;

    private static final Integer ID   = 1;
    private static final String NAME  = "Test Silva";
    private static final String EMAIL = "test@mail.com";


    private User user                   = UserMother.getUser();
    private UserDTO userDTO             = UserMother.getUserDTO();
    private Optional<User> optionalUser = UserMother.getUserOptional();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenFindByIdThenReturnUserInstance() {
       when(userRepository.findById(anyInt())).thenReturn(optionalUser);

        User response = service.findById(ID);

        assertNotNull(response);

        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
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