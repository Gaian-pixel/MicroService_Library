package gai.giorgio.microservices_library.customer.controllers;

import gai.giorgio.microservices_library.customer.exceptions.customerOptionalNotFoundException;
import gai.giorgio.microservices_library.customer.model.Customer;
import gai.giorgio.microservices_library.customer.repos.CustomerRepository;
import gai.giorgio.microservices_library.customer.services.TraceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(value = "/v2/customers")
public class CustomerController {

    @Autowired
    TraceService traceService;

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // CREATE
    @RequestMapping(method = RequestMethod.POST)
        public Customer addNewCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }


    // READ
    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable String customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isPresent()){
            return customerOptional.get();
        }else{
            throw new customerOptionalNotFoundException();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Customer> getAllCustomers() {
        log.info("Return all the customers in the database");
        List<Customer> result = new ArrayList<Customer>();
        Iterable<Customer> iterable = customerRepository.findAll();
        iterable.forEach(result::add);
        return result;
    }


    // UPDATE
    @RequestMapping(value = "/{customerId}", method = RequestMethod.PUT)
    public Customer modifyCustomer(@RequestBody Customer customer, @RequestBody String customerId ) {
        return customerRepository.save(customer);
    }


    // DELETE
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable String customerId) {
        customerRepository.deleteById(customerId);
    }
}
