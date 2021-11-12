package gai.giorgio.microservices_library.book.repos;

import gai.giorgio.microservices_library.book.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {


}
