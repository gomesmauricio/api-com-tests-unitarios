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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

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
    void whenFindByIdThenReturnSuccess() {
        when(service.findById(anyInt())).thenReturn(user);
        when(mapper.map(any(), any())).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = controller.findById(ID);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(UserDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(EMAIL, response.getBody().getEmail());
        assertEquals(PASSWORD, response.getBody().getPassword());

    }

    @Test
    void whenfindAllThenReturnAListOfUserDTO() {
        when(service.findAll()).thenReturn(List.of(user));
        when(mapper.map(any(), any())).thenReturn(userDTO);

        ResponseEntity<List<UserDTO>> response = controller.findAll();

        assertNotNull(response);//verifica se o objeto de resposta não é nulo
        assertNotNull(response.getBody());//verifica se o corpo da resposta não é null
        assertEquals(HttpStatus.OK, response.getStatusCode());//verifica se status code da resposta é 200 OK
        assertEquals(ResponseEntity.class, response.getClass());//assegurando que a resposta é do tipo ResponseEntity
        assertEquals(ArrayList.class, response.getBody().getClass());//Testa se a resposta é um array list

        assertEquals(UserDTO.class, response.getBody().get(INDEX).getClass());//Testa se objeto dentro da lista é do tipo UserDTO

        assertEquals(ID, response.getBody().get(INDEX).getId());//testa se o id do objeto na posição 0 da lista é o "0"
        assertEquals(NAME, response.getBody().get(INDEX).getName());
        assertEquals(EMAIL, response.getBody().get(INDEX).getEmail());
        assertEquals(PASSWORD, response.getBody().get(INDEX).getPassword());
    }

    @Test
    void whenCreateThenReturnCreated() {
        when(service.create(any())).thenReturn(user);

        ResponseEntity<UserDTO> response = controller.create(userDTO);

        assertEquals(ResponseEntity.class, response.getClass());//valida se a resposta é do tipo ResponseEntity
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getHeaders().get("Location"));//Valida o cabelçalho da resposta
    }

    @Test
    void whenUpdateThenReturnSuccess() {
        when(service.update(userDTO)).thenReturn(user);
        when(mapper.map(any(), any())).thenReturn(userDTO);//mocando o retorno da chamada do mapper

        ResponseEntity<UserDTO> response = controller.update(ID, userDTO);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());//testa se a classe ResponseEntity é a mesma do response
        assertEquals(UserDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(EMAIL, response.getBody().getEmail());
    }

    @Test
    void delete() {
    }
}