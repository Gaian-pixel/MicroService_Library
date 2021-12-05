package gai.giorgio.microservices_library.borrowing.repos;

import gai.giorgio.microservices_library.borrowing.model.Borrowing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface BorrowingRepository  extends MongoRepository<Borrowing, String> {
}
