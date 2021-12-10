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
    public BorrowingRepository allBorrowing(Borrowing borrowing) {
        BorrowingRepository borrowingRepository = new BorrowingRepository() {
            @Override
            public <S extends Borrowing> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public List<Borrowing> findAll() {
                return null;
            }

            @Override
            public List<Borrowing> findAll(Sort sort) {
                return null;
            }

            @Override
            public <S extends Borrowing> S insert(S s) {
                return null;
            }

            @Override
            public <S extends Borrowing> List<S> insert(Iterable<S> iterable) {
                return null;
            }

            @Override
            public <S extends Borrowing> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Borrowing> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Borrowing> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Borrowing> S save(S s) {
                return null;
            }

            @Override
            public Optional<Borrowing> findById(String s) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(String s) {
                return false;
            }

            @Override
            public Iterable<Borrowing> findAllById(Iterable<String> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(String s) {

            }

            @Override
            public void delete(Borrowing borrowing) {

            }

            @Override
            public void deleteAll(Iterable<? extends Borrowing> iterable) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Borrowing> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Borrowing> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Borrowing> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Borrowing> boolean exists(Example<S> example) {
                return false;
            }
        };
        return borrowingRepository;
    }
}
