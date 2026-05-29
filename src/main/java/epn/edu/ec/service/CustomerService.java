package epn.edu.ec.service;

import epn.edu.ec.model.cake.CakeResponse;
import epn.edu.ec.model.cake.CakesResponse;
import epn.edu.ec.model.cake.CustomerResponse;
import epn.edu.ec.model.cake.CustomersResponse;
import epn.edu.ec.repository.CakeRepository;
import epn.edu.ec.repository.CustomerRepository;
import epn.edu.ec.repository.model.Cake;
import epn.edu.ec.repository.model.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.action.internal.EntityAction;
import org.springframework.stereotype.Service;

import java.util.Comparator;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Slf4j // Agrega esta anotación para habilitar el logging
@Service

public class CustomerService {

    private final CustomerRepository customerRepository;  //Esto siempre va a aqui

    

    public boolean isVipCustomer(Long customerId) { 
        if (customerId == null) {
            log.warn("El ID del cliente es nulo");
            throw new IllegalArgumentException("El ID del cliente no puede ser nulo");
        }
        boolean isVip = customerRepository.isVipCustomer(customerId);
        log.info("Cliente con ID {} es VIP: {}", customerId, isVip);
        return isVip;
    }


    //SIEMPRE VA A ESTAR ESTO!!!
    //Todos los que son booleanos se van a crear con .is
    private CustomerResponse customerResponse(Customer customer) {
        return new CustomerResponse(customer.getId(), customer.getName(), customer.getNumber(), customer.isVip());
    }
    public CustomersResponse getCustomers() {
        return new CustomersResponse(customerRepository.findAll().stream()
                .map(this::customerResponse)
                .sorted(Comparator.comparing(CustomerResponse::getName))
                .collect(toList()));
    }


}
