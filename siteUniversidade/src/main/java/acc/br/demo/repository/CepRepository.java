package acc.br.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import acc.br.demo.model.Address;

@Repository
public interface CepRepository extends JpaRepository<Address, String> {
    Address findByCep(String cep);
}