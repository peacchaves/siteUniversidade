package acc.br.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;
    private String name;
    private String email;
    private String birthDate;
    private String cep;
    private String city;
    private String state;
    private String course;
    private String address;
}