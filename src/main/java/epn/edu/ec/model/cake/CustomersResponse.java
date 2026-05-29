package epn.edu.ec.model.cake;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomersResponse {

    private List<CustomerResponse> customers;
}
