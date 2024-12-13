package acc.br.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import acc.br.demo.model.Address;
import acc.br.demo.service.CepService;
import acc.br.demo.service.RegistrationService;

@Controller
public class StudentRegistrationController {

    @Autowired
    private CepService cepService;

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/studentRegistration")
    public String showRegistrationForm() {
        return "studentRegistration";
    }

    @PostMapping("/cep")
    public String getAddress(@RequestParam String cep, Model model) {
        Address address = cepService.findAdressByCep(cep);
        model.addAttribute("address", address);
        return "reviewRegistration";
    }

    @PostMapping("/submitRegistration")
    public String submitRegistration(Address address) {
        registrationService.save(address);
        return "success";
    }

    @PostMapping("/cancelRegistration")
    public String cancelRegistration() {
        return "cancel";
    }
}