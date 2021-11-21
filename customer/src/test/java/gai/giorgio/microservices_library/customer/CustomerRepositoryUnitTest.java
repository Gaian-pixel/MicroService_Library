package gai.giorgio.microservices_library.customer;

import gai.giorgio.microservices_library.customer.model.Customer;
import gai.giorgio.microservices_library.customer.repos.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CustomerRepositoryUnitTest {

    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void testEmptyDB(){
        assertEquals(0, customerRepository.findAll()  );
    }

    @Test
    public void testAddOneCustomer(){
        Customer customer = new Customer();
        customer.setCustomerId("1");
        customer.setName("Giorgio");
        customer.setSurname("Gai");
        customer.setAddress("Via III Alpini 12");
        customer.setTelNum("3898229875");
        customerRepository.save(customer);
        assertEquals(1, customerRepository.findAll()  );
    }


}
