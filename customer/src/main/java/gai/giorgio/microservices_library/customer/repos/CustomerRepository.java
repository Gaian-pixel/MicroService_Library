package gai.giorgio.microservices_library.customer.repos;

import gai.giorgio.microservices_library.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {


}
