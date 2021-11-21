package gai.giorgio.microservices_library.customer.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private String customerId;
    @NotBlank(message = "name is mandatory")
    private String name;
    @NotBlank(message = "surname is mandatory")
    private String surname;
    private String address;
    private String telNum;


}
