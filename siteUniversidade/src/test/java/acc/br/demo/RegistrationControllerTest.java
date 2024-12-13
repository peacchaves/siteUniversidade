package acc.br.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import acc.br.demo.controller.RegistrationController;
import acc.br.demo.model.Address;
import acc.br.demo.service.CepService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private RegistrationController registrationController;

    @Mock
    private CepService cepService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSubmitRegistration() throws Exception {
        Address address = new Address();
        address.setCep("12345678");
        address.setLogradouro("Rua Teste");
        address.setBairro("Bairro Teste");
        address.setLocalidade("Cidade Teste");
        address.setUf("Estado Teste");

        when(cepService.findAdressByCep(any())).thenReturn(address);

        mockMvc.perform(post("/submitRegistration"))
                .andExpect(view().name("success")) // Verifique a página de sucesso
                .andExpect(model().attributeExists("address"));
    }
}