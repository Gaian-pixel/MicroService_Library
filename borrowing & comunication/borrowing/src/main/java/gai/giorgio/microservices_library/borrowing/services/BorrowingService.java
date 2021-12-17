package gai.giorgio.microservices_library.borrowing.services;

import gai.giorgio.microservices_library.borrowing.model.Borrowing;
import gai.giorgio.microservices_library.borrowing.repos.BorrowingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BorrowingService {
    private final BorrowingRepository borrowingRepository ;

    public BorrowingService(final BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository ;
    }

    @Transactional
    public Borrowing addBorrowing(final String borrowingId, final String bookId, final String customerId, final String borrowingDate, final String borrowingExpDate) {
        final Borrowing borrowing = new Borrowing();
        borrowing.setBorrowingId(borrowingId);
        borrowing.setBookId(bookId);
        borrowing.setCustomerId(customerId);
        borrowing.setBorrowingDate(borrowingDate);
        borrowing.setBorrowingExpDate(borrowingExpDate);
        return this.borrowingRepository.save(borrowing);
    }

    @Transactional(readOnly = true)
    public List<Borrowing> getAllBorrowings(final int count) {
        return this.borrowingRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Borrowing> getBorrowingById(final String borrowingId) {
        return this.borrowingRepository.findById(borrowingId);
    }

}
