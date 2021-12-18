package gai.giorgio.microservices_library.borrowing.resolvers;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import gai.giorgio.microservices_library.borrowing.model.Borrowing;
import gai.giorgio.microservices_library.borrowing.repos.BorrowingRepository;
import gai.giorgio.microservices_library.borrowing.services.BorrowingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private BorrowingService borrowingService;

    public List<Borrowing> getBorrowings(final int count) {
        return this.borrowingService.getAllBorrowings(count);
    }

    public Optional<Borrowing> getBorrowing(final String borrowingId) {
        return this.borrowingService.getBorrowingById(borrowingId);
    }


}
