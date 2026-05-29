package epn.edu.ec.model.cake;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor // Agrega un constructor sin argumentos
@AllArgsConstructor
public class CustomerResponse {

    private long id;
    private String name;
    private String number;
    private boolean vip;

}
