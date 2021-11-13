package gai.giorgio.microservices_library.book;

import com.fasterxml.jackson.core.JsonProcessingException;
import gai.giorgio.microservices_library.book.repos.BookRepository;
import gai.giorgio.microservices_library.book.controllers.BookController;
import gai.giorgio.microservices_library.book.services.TraceService;
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
@WebMvcTest(BookController.class)
@AutoConfigureMockMvc
public class BookControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookRepository repository;

    @MockBean
    TraceService traceService;

    @Test
    public void testGetAllBooks() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/v2/books")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
