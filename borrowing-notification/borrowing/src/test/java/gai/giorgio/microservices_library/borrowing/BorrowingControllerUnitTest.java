package gai.giorgio.microservices_library.borrowing;


import com.fasterxml.jackson.core.JsonProcessingException;
import gai.giorgio.microservices_library.borrowing.controllers.BorrowingController;
import gai.giorgio.microservices_library.borrowing.repos.BorrowingRepository;
import gai.giorgio.microservices_library.borrowing.services.TraceService;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BorrowingController.class)
@AutoConfigureMockMvc
public class BorrowingControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BorrowingRepository repository;

    @MockBean
    TraceService traceService;

    @Test
    public void testGetAllBorrowings() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/v2/borrowing")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
}
}
