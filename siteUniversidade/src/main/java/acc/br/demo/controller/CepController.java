package acc.br.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import acc.br.demo.model.Address;
import acc.br.demo.service.CepService;
import acc.br.demo.service.RegistrationService;

@RestController
@RequestMapping("/api/cep")
public class CepController {

    private final CepService cepService;
    private final RegistrationService registrationService;

    @Autowired
    public CepController(CepService cepService, RegistrationService registrationService) {
        this.cepService = cepService;
        this.registrationService = registrationService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<Address> findCep(@PathVariable String cep) {
        Address address = cepService.findAdressByCep(cep);
        
        if (address != null) {
            registrationService.save(address);
            return ResponseEntity.ok(address);
        }
        
        return ResponseEntity.notFound().build();
    }
}