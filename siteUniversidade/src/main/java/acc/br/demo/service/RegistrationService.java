package acc.br.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import acc.br.demo.model.Address;
import acc.br.demo.repository.CepRepository;

@Service
public class RegistrationService {

    private final CepRepository cepRepository;

    @Autowired
    public RegistrationService(CepRepository cepRepository) {
        this.cepRepository = cepRepository;
    }

    @Transactional
    public void save(Address address) {
        cepRepository.save(address);
    }
}