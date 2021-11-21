package gai.giorgio.microservices_library.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import gai.giorgio.microservices_library.customer.repos.CustomerRepository;
import gai.giorgio.microservices_library.customer.controllers.CustomerController;
import gai.giorgio.microservices_library.customer.services.TraceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@AutoConfigureMockMvc
public class CustomerControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CustomerRepository repository;

    @MockBean
    TraceService traceService;

    @Test
    public void testGetAllCustomers() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/v2/customers")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
