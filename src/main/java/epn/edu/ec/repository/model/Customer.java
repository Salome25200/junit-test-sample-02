package epn.edu.ec.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

//CON EL DATA SE CREA CON MAYUSCULAS LOS ATRIBUTOS
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Entity // Indicar que esta clase es una entidad de JPA
@Table(name = "customers")

public class Customer {

    public Customer (){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String number;
    private boolean vip;

}
