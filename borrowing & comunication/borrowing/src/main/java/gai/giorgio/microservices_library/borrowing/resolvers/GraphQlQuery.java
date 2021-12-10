package gai.giorgio.microservices_library.borrowing.resolvers;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import gai.giorgio.microservices_library.borrowing.model.Borrowing;
import gai.giorgio.microservices_library.borrowing.repos.BorrowingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class GraphQlQuery implements GraphQLQueryResolver {
    public Borrowing allBorrowing() {
        Borrowing borrowing = new Borrowing() {

            public <S extends Borrowing> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            public List<Borrowing> findAll() {
                return null;
            }
        };
        return borrowing;
    }
}
