package epn.edu.ec.repository;

import java.util.Optional;

import epn.edu.ec.repository.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import epn.edu.ec.repository.model.Cake;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    boolean isVipCustomer(Long customerId); // Agrega este método para verificar si un cliente es VIP

}
