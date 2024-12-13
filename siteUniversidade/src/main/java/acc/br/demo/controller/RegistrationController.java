package acc.br.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import acc.br.demo.model.Address;
import acc.br.demo.service.CepService;
import acc.br.demo.service.RegistrationService;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    private final CepService cepService;
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(CepService cepService, RegistrationService registrationService) {
        this.cepService = cepService;
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<String> registerAddress(@RequestParam String cep) {
        Address address = cepService.findAdressByCep(cep);
        registrationService.save(address);
        return ResponseEntity.ok("Endereço registrado com sucesso");
    }
}