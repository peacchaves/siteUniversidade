package acc.br.demo.service;

import org.springframework.stereotype.Component;
import acc.br.demo.model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class CepServiceFallback implements CepService {
    private static final Logger logger = LoggerFactory.getLogger(CepServiceFallback.class);

    @Override
    public Address findAdressByCep(String cep) {
        logger.error("Erro ao buscar CEP: {}", cep);
        Address fallbackAddress = new Address();
        fallbackAddress.setCep(cep);
        fallbackAddress.setLogradouro("Endereço não encontrado");
        return fallbackAddress;
    }
}