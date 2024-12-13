package acc.br.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import acc.br.demo.model.Address;

@FeignClient(
    name = "viacep", 
    url = "https://viacep.com.br/ws/", 
    fallback = CepServiceFallback.class
)
public interface CepService {
    @GetMapping("{cep}/json")
    Address findAdressByCep(@PathVariable("cep") String cep);
}