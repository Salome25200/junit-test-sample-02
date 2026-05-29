package epn.edu.ec.service;

import epn.edu.ec.repository.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DiscountServiceTest {

    //Esto se encuentra en DiscountService, en public final eso se pone aqui del que se encuentra en la clase que se va a probar
    @Mock
    private CustomerService customerService;

    //Aqui se inyecta, es en donde encontramos public final, es decir oublic final CustomerService encontré en la clase DiscountService,
    // entonces se inyecta aqui para poder usarlo en el test
    @InjectMocks
    private DiscountService discountService;


    //Se crea aqui los clientes y se hace de esta forma
    private Customer customerMaria, customerPablo;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks

        customerMaria = Customer.builder()
                .id(1L)
                .name("Maria")
                .number("1234567890")
                .vip(true)
                .build();

        customerPablo = Customer.builder()
                .id(2L)
                .name("Pablo")
                .number("0987654321")
                .vip(false)
                .build();
    }


    //Aqui comienza los test
    @Test
    public void calculateDiscount_ShouldApplyVolumeDiscount() {
        double total = 1000;
        int quantity = 11;
        Long customerId = customerMaria.getId();

        double discount = discountService.calculateDiscount(total, quantity, customerId);

        assertEquals(150, discount, "El descuento por volumen debería ser del 15%");
    }

    //Probar que si el cliente es catalogado como VIP por el sistema y el total de la
    //compra es mayor a $500, recibe el 10% de descuento (no acumulable con el anterior
    //se aplica al mayor
    @Test
    public void calcularDescuentoSiElClienteEsVIP() {
        double total = 600;
        int quantity = 5;
        Long customerId = customerMaria.getId();

        when(customerService.isVipCustomer(customerId)).thenReturn(true);

        double discount = discountService.calculateDiscount(total, quantity, customerId);

        assertEquals(60, discount, "El descuento VIP debería ser del 10%");
    }

    //Probar que el total  no sea negativa
    @Test
    public void probarTotalNoSeaNegativa (){
        double total = -100;
        int quantity = 14;
        Long customerId = customerMaria.getId();

        try {
            discountService.calculateDiscount(total, quantity, customerId);
        } catch (IllegalArgumentException e) {
            assertEquals("Valores de entrada inválidos", e.getMessage());
        }
    }

    //Probar que la cantidad sea mayor a 0
    @Test
    public void probarCantidadMayorA0() {
        double total = -100;
        int quantity = 14;
        Long customerId = customerMaria.getId();

        try {
            discountService.calculateDiscount(total, quantity, customerId);
        } catch (IllegalArgumentException e) {
            assertEquals("Valores de entrada inválidos", e.getMessage());
        }

    }
        //Si no cumple ninguna condición o el cliente no es VIP, el descuento es 0%
        @Test
                public void probarDescuentoCeroSiNoCumpleCondiciones() {
            double total = 100;
            int quantity = 5;
            Long customerId = customerPablo.getId();

            when(customerService.isVipCustomer(customerId)).thenReturn(false);
        }
    }



