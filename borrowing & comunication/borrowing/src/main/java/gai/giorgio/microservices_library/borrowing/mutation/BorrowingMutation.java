package gai.giorgio.microservices_library.borrowing.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import gai.giorgio.microservices_library.borrowing.model.Borrowing;
import gai.giorgio.microservices_library.borrowing.services.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BorrowingMutation implements GraphQLMutationResolver {

    @Autowired
    private BorrowingService borrowingService;

    public Borrowing addBorrowing(final String borrowingId, final String bookId, final String customerId, final String borrowingDate, final String borrowingExpDate) {
        return this.borrowingService.addBorrowing(borrowingId, bookId, customerId, borrowingDate,borrowingExpDate);
    }
}
