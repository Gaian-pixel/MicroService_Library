package gai.giorgio.microservices_library.borrowing;

import gai.giorgio.microservices_library.borrowing.model.Borrowing;
import gai.giorgio.microservices_library.borrowing.repos.BorrowingRepository;
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
public class BorrowingRepositoryUnitTest {

    @Autowired
    private BorrowingRepository borrowingRepository;


    @Test
    public void testEmptyDB(){
        assertEquals(0, borrowingRepository.findAll().size()  );
    }

    @Test
    public void testAddOneBorrowing(){
        Borrowing borrowing = new Borrowing();
        borrowing.setBorrowingId("1");
        borrowing.setBookId("56787");
        borrowing.setCustomerId("445542");
        borrowing.setBorrowingDate("19-3-2020");
        borrowing.setBorrowingExpDate("31-3-2020");
        borrowingRepository.save(borrowing);
        assertEquals(1, borrowingRepository.findAll().size()  );
    }
}
